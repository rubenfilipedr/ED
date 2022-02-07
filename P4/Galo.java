import java.util.Scanner;



class Game {
  int dim;      //dimensão
  char v[][];    //elementos da matriz


  Game(int n) {    //construtor
    dim = n;
    v = new char[n][n];
  }


  public void read(Scanner in) {    //ler elementos da matriz
    for (int i=0 ; i<dim ; i++) {
      String temp = in.next();
      for (int j=0 ; j<dim ; j++) {
        v[i][j] = temp.charAt(j);
      }
    }
  }


  boolean finished () {   //verifica se o tabuleiro esta fechado
    for (int i=0 ; i<dim ; i++) {
      for (int j=0 ; j<dim ; j++) {
        if (v[i][j] == '.')
          return false;
      }
    }
    return true;
  }


  void verify (int x, int y, int incrx, int incry) {    //verificar a linha q começa em (x,y)
    int xx = x;
    int yy = y;
    if (v[x][y] == '.')
      return;
    for (int i=0 ; i<dim ; i++, xx+=incrx, yy+=incry) {
      if (v[x][y] != v[xx][yy])
        return;
    }
    win(v[x][y]);
  }


  void win (char player) {    //escreve mensagem do vencedor
    System.out.println("Ganhou o " + player);
    System.exit(0);
  }


  void check() {
    for (int i=0 ; i<dim ; i++)
      verify (i, 0, 0, 1);    //verificar linhas
    for (int j=0 ; j<dim ; j++)
      verify (0, j, 1, 0);    //verificar colunas
    verify (0, 0, 1, 1);    //verificar diagonal principal
    verify (0, dim-1, 1, -1);   //verificar diagonal secundária

    //depois de feitos todos os testes para verificar
    //se alguem ganhou, ou nao acabou ou houve empate
    if (!finished())
      System.out.println("Jogo incompleto");
    else
      System.out.println("Empate");
  }




}




class Galo {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Game jogo = new Game(n);
    jogo.read(in);
    jogo.check();

  }

}
