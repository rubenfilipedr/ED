import java.util.Scanner;



class Caixa {                                 // Classe Caixa
  public int numProdutos;
  public int numClientes;
  public int rapidez;
  public int livre;

  Caixa(int r) {
    rapidez = r;
    numProdutos = 0;
    numClientes = 0;
    livre = 0;

  }
}



class Cliente {                               // Classe Cliente
  public String nome;
  public int chegada;
  public int produtos;
  public int saida;

  Cliente(String n, int c, int np) {
    nome = n;
    chegada = c;
    produtos = np;
    saida = -1;
  }
}



class FilaAtendimento {                       // Classe Fila
  public MyQueue<Cliente> fila;

  FilaAtendimento() { fila = new LinkedListQueue<Cliente>(); }
}



class ED115 {

  private static int numCaixas;
  private static int numClientes;
  private static Caixa caixas[];
  private static FilaAtendimento filaClientes;

  private static void lerClientes(Scanner in) {
    numClientes = in.nextInt();
    for(int i=0 ; i<numClientes ; i++) {
      String nome = in.next();
      int chegada = in.nextInt();
      int produtos = in.nextInt();
      Cliente c = new Cliente(nome, chegada, produtos);
      filaClientes.fila.enqueue(c);
    }
  }

  private static void mostrarClientes() {
    int livre = 0;
    for(int i=0 ; i<numClientes ; i++) {
      Cliente c = filaClientes.fila.dequeue();
      System.out.print(c.nome + " ");
      int chegada = c.chegada;
      System.out.print(chegada + " ");
      if (chegada <= livre) { chegada = livre; }
      int atendimento = 10+(c.produtos*caixas[0].rapidez);
      c.saida = chegada + atendimento;
      System.out.println(c.saida);
      livre = c.saida;
    }
  }

  private static int caixaMenosClientes() {
    int temp = 0;
    for(int i=1 ; i<numCaixas ; i++) {
      if (caixas[i].numClientes < caixas[temp].numClientes) { temp = i; }
    }
    return temp;
  }

  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    filaClientes = new FilaAtendimento();
    int flag = scan.nextInt();
    int numCaixas = scan.nextInt();
    caixas = new Caixa[numCaixas];
    for(int i=0 ; i<numCaixas; i++) {
      int r = scan.nextInt();
      caixas[i] = new Caixa(r);
    }
    lerClientes(scan);

    if (flag == 1) {
      mostrarClientes();
    }
    if (flag == 2){

    }



    /*  } else if ( flag == 2 ) {
    int ts[] = new int[N];
    int count[] = new int[N];
    int products[] = new int[N];
    for (int i=0 ; i<C ; i++) {
    list.dequeue();
    int betterChoice = 0;
    for (int j=0 ; j<N ; j++) {
    if ( count[j] < count[betterChoice] ) { betterChoice = j; }
    else if ( count[j] == count[betterChoice] ) {
    if ( products[j] < products[betterChoice] ) { betterChoice = j; }
    else if ( products[j] == products[betterChoice] ) {
    if ( j<betterChoice ) { betterChoice = j; }
  }
}
}
int tc = Integer.parseInt(list.dequeue());
int p = Integer.parseInt(list.dequeue());
count[betterChoice]++;
products[betterChoice] += p;

}


for (int i=0 ; i<N ; i++) {
System.out.println("Caixa #" + (i+1) + ": " + count[i] + " " + products[i]);
}
*/
}


}
