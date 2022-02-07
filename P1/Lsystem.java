import java.util.Scanner;

public class Lsystem {

  public static void main (String[] args) {
    String str = "A";
    Scanner stdin = new Scanner(System.in);
    int n = stdin.nextInt();
    System.out.println(str);
    for (int i=1 ; i<n ; i++) {
      str = str.replaceAll("A","AB").replaceAll("BB","BA");
      System.out.println(str);
    }
  }

}
