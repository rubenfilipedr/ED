import java.util.Scanner;

public class ED201 {
  static int D;     // Duração da viagem
  static int betterOption = 0;

  // Escrever todos os subconjuntos do array v[]
  static void sets(int v[]) {
    // array de booleanos para representar o conjunto
    boolean used[] = new boolean[v.length];
    goSets(0, v, used); // chamar funcao recursiva
    System.out.println(betterOption);
  }

  // Gera todos os subconjuntos a partir da posicao 'cur'
  static void goSets(int cur, int v[], boolean used[]) {
    if (cur == v.length) {  // Caso base: terminamos o conjunto
      int sum = 0;
      for (int i=0; i<v.length; i++) { if (used[i]) sum += v[i]; }
      if (sum<=D && sum>betterOption) { betterOption = sum; }
    } else {                  // Se nao terminamos, continuar a gerar
      used[cur] = true;      // Subconjuntos que incluem o elemento actual
      goSets(cur+1, v, used);// Chamada recursiva
      used[cur] = false;     // Subconjuntos que nao incluem o el. actual
      goSets(cur+1, v, used);// Chamada recursiva
    }
  }


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    D = scan.nextInt();   // Duração da viagem
    int N = scan.nextInt();   // Número de músicas disponíveis
    int v[] = new int[N];

    for (int i=0 ; i<N ; i++) {
      v[i] = scan.nextInt();
    }

    sets(v);

  }


}
