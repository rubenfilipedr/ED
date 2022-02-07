import java.util.Scanner;

public class Pal {


  public static boolean isPalindromo (String str) {
    str = str.toLowerCase().replaceAll("[^a-z]","");
    int j = str.length()-1;

    for (int i=0 ; i<=j ; i++, j--) {
      if (str.charAt(i)!=str.charAt(j))
        return false;
    } return true;
  }


  public static void main (String[] args) {

    Scanner stdin = new Scanner(System.in);
    String str = stdin.nextLine();

    if (isPalindromo(str)) {
      System.out.println("True.");
    } else {
      System.out.println("False.");
    }

  }


}
