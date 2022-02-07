import java.util.Scanner;

class ED029 {

  public static void main (String[] args) {

    Scanner scan = new Scanner(System.in);
    int C = scan.nextInt();     // numero de casos
    while (C > 0) {
      MyQueue<String> riseList = new LinkedListQueue<>();
      MyQueue<String> landList = new LinkedListQueue<>();
      int L = scan.nextInt();   // avioes para levantar
      int A = scan.nextInt();   // avioes para aterrar
      for (int i=0 ; i<L*2 ; i++) {
        riseList.enqueue(scan.next());  // scan do Nome | Min_Desejado
      }
      for (int j=0 ; j<A*2 ; j++) {
        landList.enqueue(scan.next());  // scan do Nome | Min_Desejado
      }
      


      C--;
    }

  }


}
