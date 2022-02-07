import java.util.Scanner;

class ED164 {

  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();

    // Criacao da Arvore
    BSTree<String> t = new BSTree<String>();

    for (int i=0 ; i<N ; i++) {
      t.insert(scan.next());
    }

    System.out.println(t.numberNodes());

  }

}
