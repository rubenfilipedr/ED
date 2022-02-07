import java.util.Scanner;


public class ED200 {
  static int rows;            // Numero de linhas
  static int cols;            // Numero de colunas
  static char m[][];          // Matriz de celulas
  static boolean visited[][]; // Saber se uma dada posicao ja foi visitada


  static int t(int y, int x) {
    if (y<0 || y>=rows || x<0 || x>=cols) return 0; // Caso base: fora dos limites
    if (visited[y][x]) return 0;  // Caso base: celula ja visitada
    if (m[y][x] == '.') return 0; // Caso base: celula vazia
    int count = 1;        // celula nao vazia
    visited[y][x] = true; // marcar como visitada
    count += t(y-1, x);   // Adicionando celulas nao vizinhas
    count += t(y+1, x);
    count += t(y, x+1);
    count += t(y, x-1);
    count += t(y-1, x-1);
    count += t(y-1, x+1);
    count += t(y+1, x-1);
    count += t(y+1, x+1);
    return count;
  }


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Número de casos
    int n = scan.nextInt();

    // Fazer n casos
    for (int k=0 ; k<n ; k++) {
      int bigger = 0;
      // Ler rows e cols
      rows = scan.nextInt();
      cols = scan.nextInt();
      // Criar matriz m e visited
      m = new char[rows][cols];
      visited = new boolean[rows][cols];
      // Ler os valores da matriz m
      for (int i=0; i<rows; i++) m[i] = scan.next().toCharArray();

      for (int i=0 ; i<rows; i++) {
        for (int j=0 ; j<cols ; j++) {
          if (visited[i][j]==false) {
            int spot = t(i, j);
            if ( spot > bigger ) bigger = spot;
          }
        }
      }

      System.out.println(bigger);

    }

  }

}
