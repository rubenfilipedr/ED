import java.util.Scanner;

public class ED202 {
  static char names[];
  static float distance[][];


  static void permutations(String v[], float dist[][]) {
    boolean used[] = new boolean[v.length]; // $i$ esta na permutacao?
    int perm[] = new int[v.length];         // permutacao actual
    int i;
    float smaller = 0;
    for (i=0 ; i<v.length-1 ; i++) { smaller += dist[i][i+1]; }
    smaller += dist[i][0];
    goPerm(0, v, used, perm, dist, smaller); // chamar funcao recursiva
    System.out.println(smaller);
  }

  // Gera todos os subconjuntos a partir da posicao 'cur'
  static void goPerm(int cur, String v[], boolean used[], int perm[], float dist[][], float smaller) {
    float sum = 0;
    int i, j;
    if (cur == v.length) {  // Caso base: terminamos a permutacao
      for (i=0; i<v.length-1; i++) {
        sum += dist[perm[i]][perm[i+1]];
      }
      sum += dist[perm[i]][perm[0]];
      if (sum < smaller) {
        smaller = sum;
        System.out.println(smaller);
      }
    } else { // Se nao terminamos, continuar a gerar
      for (i=0; i<v.length; i++) // Tentar todos os elementos
      if (!used[i]) {
        used[i] = true; perm[cur] = i;
        goPerm(cur+1, v, used, perm, dist, smaller);
        used[i] = false;
      }
    }
    if (sum < smaller) {
      smaller = sum;
    }
  }


  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt(); // Número de locais
    String names[] = new String[N];
    float distance[][] = new float[N][N];
    for (int i=0 ; i<N ; i++) { names[i] = scan.next(); }
    for (int i=0 ; i<N ; i++) {
      for (int j=0 ; j<N ; j++) { distance[i][j] = scan.nextFloat();  }
    }
    permutations(names, distance);

  }



}
