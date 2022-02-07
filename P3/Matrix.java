import java.util.Scanner;

class Matrix {
  int data[][]; // os elementos da matriz em si
  int rows;     // numero de linhas
  int cols;     // numero de colunas

  // construtor padrao de matriz
  Matrix(int r, int c) {
    data = new int[r][c];
    rows = r;
    cols = c;
  }

  // Ler os rows x cols elementos da matriz
  public void read(Scanner in) {
    for (int i=0; i<rows; i++)
    for (int j=0; j<cols; j++)
    data[i][j] = in.nextInt();
  }

  // Representacao em String da matriz
  public String toString() {
    String ans = "";
    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++)
      ans += data[i][j] + " ";
      ans += "\n";
    }
    return ans;
  }



  public static Matrix identity(int n) {
    Matrix m = new Matrix(n,n);
    for (int i=0 ; i<n ; i++) {
      for (int j=0 ; j<n ; j++) {
        if (i==j) {
          m.data[i][j] = 1;
        } else {
          m.data[i][j] = 0;
        }
      }
    }
    return m;
  }



  public Matrix transpose() {
    Matrix nova = new Matrix(cols,rows);
    for (int i=0 ; i<cols ; i++) {
      for (int j=0 ; j<rows ; j++) {
        nova.data[i][j] = data[j][i];
      }
    }
    return nova;
  }



  public Matrix sum(Matrix m) {
    Matrix soma = new Matrix(rows,cols);
    for (int i=0 ; i<rows ; i++) {
      for (int j=0 ; j<cols ; j++) {
        soma.data[i][j] = data[i][j] + m.data[i][j];
      }
    }
    return soma;
  }



  public Matrix multiply(Matrix m) {
    Matrix multip = new Matrix(rows,m.cols);
    int k = cols;
    for (int i1=0 ; i1<rows ; i1++) {
      for(int j1=0 ; j1<m.cols ; j1++) {
        for (int ij=0 ; ij<k ; ij++) {
          multip.data[i1][j1] += (data[i1][ij]*m.data[ij][j1]);
        }
      }
    }
    return multip;
  }

}
