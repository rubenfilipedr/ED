import java.util.Scanner;

public class Statistics {

  static int range(int v[],int size) {
    int max = v[0], min = v[0];
    for (int i=1 ; i<size ; i++) {
      if (v[i]>max)
        max = v[i];
      if (v[i]<min)
        min = v[i];
    }
    return (max-min);
  }

  static float average(int v[],int size) {
    float sum = 0;
    int i;
    for (i=0 ; i<size ; i++) {
      sum += v[i];
    }
    return (sum/i);
  }

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);
    int size = stdin.nextInt();
    int v[] = new int[size];
    for (int i=0 ; i<size ; i++) {
      v[i] = stdin.nextInt();
    }
    System.out.printf("%.2f\n", average(v,size));
    System.out.println(range(v,size));
  }

}
