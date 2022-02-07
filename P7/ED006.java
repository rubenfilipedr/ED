import java.util.Scanner;

public class ED006 {
  public static void main (String[] args) {

    Scanner scan = new Scanner(System.in);
    // numero de casos
    int N = scan.nextInt();
    scan.nextLine();
    for (int k=0 ; k<N ; k++) {

      // lista das crinacas
      CircularLinkedList<String> childList = new CircularLinkedList<>();

      String line = scan.nextLine();       // frase
      int count = line.split(" ").length;  // numero de palavras

      int child = scan.nextInt();         // numero de crianças

      // adiconar as criancas à lista
      for (int i=0 ; i<child ; i++) { childList.addLast(scan.next()); }
      scan.nextLine();

      for (int i=0 ; i<(child-1) ; i++) {     // eliminar x-1 criancas das x totais
        for (int j=0 ; j<(count-1) ; j++) {
          childList.rotate();
        }
        childList.removeFirst();
      }

      if (childList.getFirst().equals("Carlos")) {
        System.out.println("O Carlos nao se livrou");
      } else {
        System.out.println("O Carlos livrou-se (coitado do " + childList.getFirst() + "!)");
      }

    }

  }
}
