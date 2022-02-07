import java.util.Scanner;

class Sopa {
  private int lines, cols;
  private char m[][];
  private char m2[][];

  Sopa (int l, int c) {
    lines = l;
    cols = c;
    m = new char[l][c];
    for (int i=0 ; i<lines ; i++) {
      for (int j=0 ; j<cols ; j++) {
        m2[i][j] = '.';
      }
    }
  }

  public void read (Scanner in) {
    for (int i=0 ; i<lines ; i++) m[i] = in.next().toCharArray();
  }

  public void verify (char p[], int k) {
    for (int i=0 ; i<lines ; i++) {
      for (int j=0 ; j<cols ; j++) {
        compare(p, k, 1, 0, i, j);
        compare(p, k, -1, 0, i, j);
        compare(p, k, 0, 1, i, j);
        compare(p, k, 0, -1, i, j);
      }
    }
  }

  public void compare (char p[], int k, int incrx, int incry, int xi, int yi) {
    int xx = xi;
    int yy = yi;
    int k2 = 0;
    for (int i=0 ; i<lines ; i++) {
      for (int j=0 ; j<cols ; j++) {
        if ( m[xx][yy] == p[k][k2] ) {
          k2++;
          xx += incrx;
          yy += incry;
        } else {
          xx += incrx;
          yy += incry;
        }
      }
    }

  }



}


public class Letras {
  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    int lines = in.nextInt();
    int cols = in.nextInt();
    Sopa g = new Sopa(lines, cols);
    read();
    int n = in.nextInt();
    char pal = new char[n];
    for (int i=0 ; i<n ; i++) {
      pal[i] = in.next().toCharArray();
    }
    for (int i=0 ; i<n ; i++) {
      m.verify(pal, i);
    }

  }
}
