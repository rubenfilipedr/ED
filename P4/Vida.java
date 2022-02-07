import java.util.Scanner;

class GameLife {
  final char DEAD = '.';
  final char ALIVE = 'O';
  private int rows, cols;
  private char m[][];

  GameLife (int r, int c) {
    rows = r;
    cols = c;
    m = new char [r][c];
  }

  public void read (Scanner in) {
    for (int i=0 ; i<rows ; i++) {
      m[i] = in.next().toCharArray();
    }
  }

  public void write() {
    for (int i=0 ; i<rows ; i++) {
      for (int j=0 ; j<cols ; j++) {
        if (m[i][j] == ALIVE) {
          System.out.print(ALIVE);
        } else {
          System.out.print(DEAD);
        }
      }
      System.out.println();
    }
  }

  public int countAlive (int y, int x) {
    int count = 0;
    for (int i=-1 ; i<=1 ; i++) {
      for (int j=-1 ; j<=1 ; j++) {
        if ( (y+i)>=0 && (y+i)<rows && (x+j)>=0 && (x+j)<cols ) {
          if ( m[y+i][x+j]==ALIVE && ( i!=0 || j!=0 ) ) {
            count++;
          }
        }
      }
    }
    return count;
  }

  public void iterate() {
    int i, j, viz;
    char m2[][] = new char[rows][cols];

    for (i=0 ; i<rows ; i++) {
      for (j=0 ; j<cols ; j++) {
        viz = countAlive(i, j);
        if (m[i][j]==ALIVE && (viz<=1 || viz>=4))
          m2[i][j] = DEAD;
        else if (m[i][j]==ALIVE && (viz>1 && viz<4))
          m2[i][j] = ALIVE;
        else if (m[i][j]==DEAD && viz==3)
          m2[i][j] = ALIVE;
        else
          m2[i][j] = DEAD;
      }
    }

    for (i=0 ; i<rows ; i++) {
      for (j=0 ; j<cols ; j++) {
        m[i][j] = m2[i][j];
      }
    }

  }

}




public class Vida {
  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);

    int rows = in.nextInt();    // linhas da matriz
    int cols = in.nextInt();    // colunas da matriz
    int n = in.nextInt();   // iterações

    GameLife g = new GameLife(rows, cols);    // criação do jogo
    g.read(in);   // ler os valores iniciais para o jogo
    for (int k=0 ; k<n ; k++) {   // n iterações
      g.iterate();
    }
    g.write();    // printar após iterações

  }
}
