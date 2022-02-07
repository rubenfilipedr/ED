import java.util.Scanner;


class ED231 {


  public static void Flag1(int C[], int N) {
    int min = C[1]-C[0];            //  Considero o min e max como sendo o
    int max = C[1]-C[0];            //  aumento do dia 0 para o dia 1
    for (int i=2 ; i<N ; i++) {
      int temp = C[i]-C[i-1];       // Aumento desse dia
      if (temp < min) { min = temp; }   // comparação com o aumento
      if (temp > max) { max = temp; }   // max e min
    }
    System.out.println(min + " " + max);
  }


  public static void Flag2(int C[], int N) {
    int periodoBaixaProp = 0;      // Periodos de baixa propagacao;
    int maiorPeriodo = 0;          // Maior periodo de baixa prop
    int tempMaiorPeriodo = 0;      // Variavel tempoararia para comparar com o maiorPeriodo
    int ant = 1;            // Dia anterior (1 = Alta propagacao, 2 = Baixa propagacao)

    for (int i=1 ; i<N ; i++) {
      double percentagem = ( (C[i] - C[i-1]) * 100.0 / C[i-1] );
      if (percentagem <= 5) {   // Dia com baixa propagacao
        if (ant == 1) { periodoBaixaProp++; }   // Anterior com alta propagacao
        tempMaiorPeriodo++;   // Novo periodo de baixa prop
        ant = 0;              // E o dia de hoje, que sera o Anterior teve baixa prop (logo =0)
      } else {                // Se for um dia com alta propagacao
        if (tempMaiorPeriodo > maiorPeriodo) { maiorPeriodo = tempMaiorPeriodo; } // Comparar periodo dessa "vaga" com o maior periodo
        tempMaiorPeriodo = 0; // Como ira começar um novo periodo devido a percentagem do dia ter sido >5 entao temp começa do 0
        ant = 1;              // Percentagem nesse dia >5 logo Anterior = 1 (Alta propagacao)
      }
    }
    if (tempMaiorPeriodo > maiorPeriodo) { maiorPeriodo = tempMaiorPeriodo; }   // Qnd terminar o ciclo, ao terminar com baixa propagação
                                                                                // temos de comparar novamente a temp com o maiorPeriodo registado
    System.out.println(periodoBaixaProp + " " + maiorPeriodo);
  }


  public static void Flag3(int C[], int N) {
    int cols = N;                       // Colunas = Numero de dias
    int lines = C[N-1] / 100;           // Linhas = Numero de casos no ultimo dia / 100
    char m[][] = new char[lines][cols];

    for (int j=0 ; j<cols ; j++) {   // Comecar na primeira coluna
      int valor = C[j] / 100;        // Guardar o valor correspondente a essa coluna e dividir por 100 (Parte inteira)
      for (int i=lines-1 ; i>=0 ; i--) {  // Começar da ultima linha e ir subindo
        if (valor > 0) {      // Parte inteira da divisão >0
          m[i][j] = '#';
          valor--;            // Subtrai-se 1 porque cada linha corresponde a uma unidade
        } else {              // Se a parte inteira já for <=0 já não é necessário substrair
          m[i][j] = '.';
        }
      }
    }

    for (int i=0 ; i<lines ; i++) {
      System.out.println(m[i]);   // Printar por linhas
    }

  }



  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();     // Numero de dias consecutivos
    int C[] = new int[N];       // Casos confirmados diariamente
    for (int i=0 ; i<N ; i++) {
      C[i] = scan.nextInt();
    }
    int flag = scan.nextInt();  // Flag (Subtarefa)

    if (flag == 1) { Flag1(C, N); }
    if (flag == 2) { Flag2(C, N); }
    if (flag == 3) { Flag3(C, N); }
  }

}
