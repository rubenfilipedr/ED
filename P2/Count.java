import java.util.Scanner;

public class Count {
  public static void main (String[] args) {

    Scanner stdin = new Scanner(System.in);

    int counter = 0;
    while (stdin.hasNext()) {
      counter++;
      String s = stdin.next();
      System.out.println(counter + ": " + s);
    }

  }
}
