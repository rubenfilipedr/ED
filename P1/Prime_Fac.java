import java.util.Scanner;

public class Prime_Fac {


  static void Fact(int n) {
    for (int i=2 ; n>1 ; ) {
      if ( n%i == 0 ) {
        System.out.print(i);
        n = n/i;
        if ( n != 1 ) {
          System.out.print(" * ");
        }
      } else {
        i++;
      }
    }
  }


  public static void main (String[] args) {
    Scanner stdin = new Scanner(System.in);
    int n = stdin.nextInt();
    System.out.print(n + " = ");
    Fact(n);
    System.out.println();
  }


}
