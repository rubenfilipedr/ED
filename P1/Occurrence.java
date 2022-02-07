import java.util.Scanner;

public class Occurrence {

  public static void main (String[] args) {
    int j, k = 0;
    Scanner stdin = new Scanner(System.in);
    System.out.println("Indique o tamanho do array (n).");
    int n = stdin.nextInt();
    int v[] = new int[n];
    System.out.println("Indique os valores.");
    for (j=0 ; j<n ; j++) {
      v[j] = stdin.nextInt();
    }
    System.out.println("Indique um i.");
    int i = stdin.nextInt();
    for (j=0 ; j<n ; j++) {
      if (v[j]==i) {
        k++;
      }
    }
    System.out.println("O numero de ocurrencias de " + i + " no array é " + k + ".");
  }

}
