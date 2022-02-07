import java.util.Scanner;

public class Palindromo {



  static boolean isPalindromo (String str) {
    str = str.toLowerCase().replaceAll("[^a-z]","");
    int j = str.length()-1;

    for (int i=0 ; i<=j ; i++, j--) {
      if (str.charAt(i)!=str.charAt(j))
        return false;
    } return true;
  }



  public static void main (String[] args) {

    Scanner stdin = new Scanner(System.in);
    int N = stdin.nextInt();
    System.out.println(N);
    stdin.nextLine();

    for (int i=0 ; i<N ; i++) {
      String str = stdin.nextLine();
      if (isPalindromo(str)) {
        System.out.println("sim");
      } else {
        System.out.println("nao");
      }
    }

  }


}
