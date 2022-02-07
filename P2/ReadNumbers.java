import java.util.Scanner;

public class ReadNumbers {

  static int range(int v[]) {
    int max = v[0], min = v[0];
    for (int i=1 ; i<v.length ; i++) {
      if (v[i]>max)
        max = v[i];
      if (v[i]<min)
        min = v[i];
    }
    return (max-min);
  }

  static void writeArray(int v[]) {
    for (int i=0 ; i<v.length ; i++) {
      System.out.println("v[" + i + "] = " + v[i]);
    }
  }


  public static void main (String[] args) {
    Scanner stdin = new Scanner(System.in);
    System.out.println("Quantos inteiros deverá aceitar?");
    int k = stdin.nextInt();
    int v[] = new int[k];
    System.out.println("Quantos números se seguem?");
    int n = stdin.nextInt();
    System.out.println("Indique os números.");
    for (int i=0 ; i<n ; i++) {
      v[i] = stdin.nextInt();
    }
    writeArray(v);
    System.out.println("Amplitude: " + range(v));
  }
}
