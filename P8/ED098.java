import java.util.Scanner;
import java.util.LinkedList;


class Doente {
  public String nome;       // Nome
  public int chegada;       // Tempo q chega
  public int atendimento;   // Tempo q demora a ser atendido
  public int entrada;       // Tempo em q comecou o atendimento

  Doente(String n, int c, int a) {
    nome = n;
    chegada = c;
    atendimento = a;
    entrada = -1;
  }
}


class Equipa {
  int numDoentes;           // Num de doentes q atenderam
  int totalAtendimento;     // Total de tempo passado a atender
  int livre;                // Temp em q ficaram livres para novos atendimentos

  Equipa() {
    numDoentes = 0;
    totalAtendimento = 0;
    livre = 0;
  }

  void novoDoente(Doente d, int t) {
    numDoentes++;
    totalAtendimento += d.atendimento;
    livre = t + d.atendimento;
  }
}


class FilaAtendimento {
  public MyQueue<Doente> fila;

  FilaAtendimento() { fila = new LinkedListQueue<Doente>(); }
}


class ED098 {
  private static final int NUM_CORES = 5;
  private static final String[] CORES = {"Vermelho", "Laranja", "Amarelo", "Verde", "Azul"};

  private static int numEquipas;                // Num de equipas
  private static int numDoentes;                // Num de doentes
  private static FilaAtendimento emEspera[];    // Array c fila p cada cor
  private static LinkedList<Doente> atendidos;  // Lista d doentes ja atendidos
  private static Equipa equipas[];              // Equipas de urgencia

  private static int indiceCor(String s) {
    for (int i=0 ; i<NUM_CORES ; i++) {
      if ( s.equals(CORES[i]) ) { return i; }
    }
    return -1;
  }

  private static void lerDoentes(Scanner in) {
    while (in.hasNext()) {
      String nome = in.next();
      String cor = in.next();
      int chegada = in.nextInt();
      int atendimento = in.nextInt();
      Doente d = new Doente(nome, chegada, atendimento);
      emEspera[indiceCor(cor)].fila.enqueue(d);
      numDoentes++;
    }
  }

  private static void mostrarCores() {    // flag == 0
    System.out.println("------------");
    System.out.println("Cores     ND");
    System.out.println("------------");
    for (int i=0 ; i<NUM_CORES; i++) {
      System.out.printf("%8s %3d\n", CORES[i], emEspera[i].fila.size());
    }
    System.out.println("------------");
    System.out.printf("Numero doentes atendidos: %d\n", numDoentes);
  }

  private static void mostrarAtendidos() {
    System.out.println("---------------------------");
    System.out.println("Lista dos doentes atendidos");
    System.out.println("---------------------------");
    double mediaEspera = 0.0;
    for (Doente d : atendidos) {
      int te = d.entrada - d.chegada;
      mediaEspera += te;
      int ts = d.entrada + d.atendimento;
      System.out.print(d.nome + " ");             // Nome
      System.out.print(d.chegada + " ");          // Tempo de chegada
      System.out.print(te + " ");                 // Tempo de espera
      System.out.println(ts);                     // Tempo de saida
    }
    System.out.println("---------------------------");
    mediaEspera = mediaEspera / (double)numDoentes;
    System.out.printf("Tempo medio de espera: %.1f\n", mediaEspera);
  }

  private static void mostrarEquipas() {
    System.out.println("-----------------------");
    System.out.println("Equipa NDoentes MediaTA");
    System.out.println("-----------------------");
    for (int i=0 ; i<numEquipas ; i++) {
      float mediaAtendimento = (float)equipas[i].totalAtendimento / (float)equipas[i].numDoentes;
      System.out.printf("%6d%9d%8.1f\n", i, equipas[i].numDoentes, mediaAtendimento);
    }
  }

  private static int proximaEquipaLivre() {
    int temp = 0;
    for (int i=1 ; i<numEquipas ; i++) {
      if ( equipas[i].livre < equipas[temp].livre ) { temp = i; }
    }
    return temp;
  }

  private static int proximoDoente(int tempo) {
    for (int i=0 ; i<NUM_CORES ; i++) {
      if (emEspera[i].fila.size() > 0 && emEspera[i].fila.first().chegada <= tempo) {
        return i;
      }
    }
    return -1;
  }

  private static void simular() {
    int tempo = 0;
    while (atendidos.size() < numDoentes) {
      int E = proximaEquipaLivre();
      tempo = equipas[E].livre;
      while (proximoDoente(tempo)==-1) { tempo++; }
      Doente proxD = emEspera[proximoDoente(tempo)].fila.dequeue();
      equipas[E].novoDoente(proxD, tempo);
      proxD.entrada = tempo;
      atendidos.addLast(proxD);
    }
  }

  private static void inicializar() {
    numDoentes = 0;

    emEspera = new FilaAtendimento[NUM_CORES];
    for (int i=0; i<NUM_CORES;i++)
    emEspera[i] = new FilaAtendimento();

    atendidos = new LinkedList<Doente>();

    equipas = new Equipa[numEquipas];
    for (int i=0; i<numEquipas; i++)
    equipas[i] = new Equipa();
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int flag   = in.nextInt();
    numEquipas = in.nextInt();

    inicializar();
    lerDoentes(in);

    if (flag==0) {
      mostrarCores();
    } else {
      simular();
      if (flag==2) mostrarEquipas();
      mostrarAtendidos();
    }
  }


}
