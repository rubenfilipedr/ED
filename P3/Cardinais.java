import java.util.Scanner;

public class Cardinais
{
  int col, line;
  char[][] data;

  Cardinais(int a, int b)
  {
    line = a;
    col  = b;
    data = new char[a][b];
  }

  public String toString()
  {
    String ans = "";
    for (int i=0; i<line; i++)
    {
      for (int j=0; j<col; j++)
      ans += data[i][j] + " ";
      ans += "\n";
    }
    return ans;
  }
  public int countSize()
  {
    int countl    = 0;
    int countc 	  = 0;
    int countctmp = 0;
    int countltmp = 0;

    for(int i=0; i<line ; i++)
    {
      for (int j=0; j<col; j++)
      {
        if(data[i][j]=='#')
        {
          countctmp+=1;
        }
        if(data[i][j]=='.')
        {
          if(countctmp >= countc)
          {
            countc=countctmp;
          }
          countctmp=0;
        }
      }
      if(countctmp > countc)
      {
        countc=countctmp;
      }
      countctmp=0;
    }

    for(int i=0; i<col ; i++)
    {
      for (int j=0; j<line; j++)
      {
        if(data[j][i]=='#')
        {
          countltmp+=1;
        }
        if(data[j][i]=='.')
        {
          if(countltmp >= countl)
          {
            countl=countltmp;
          }
          countltmp=0;
        }
      }
      if(countltmp > countl)
      {
        countl=countltmp;
      }
      countltmp=0;
    }

    if(countc > countl) return countc;
    return countl;
  }


  public int nvezes(int n)
  {
    int count  = 0;
    int countl = 0;
    int countc = 0;
    for(int i=0; i<line ; i++)
    {
      for (int j=0; j<col; j++)
      {
        if(data[i][j]=='#')
        {
          countc+=1;
        }
        if(data[i][j]=='.') countc=0;
        if(countc==n)
        {
          count++;
          countc=0;
        }
      }
      countc=0;
    }

    for(int i=0; i<col ; i++)
    {
      for (int j=0; j<line; j++)
      {
        if(data[j][i]=='#')
        {
          countl+=1;
        }
        if(data[j][i]=='.') countl=0;
        if(countl==n)
        {
          count++;
          countl=0;
        }
      }
      countl=0;
    }
    return count;
  }


  public static void main(String[] args)
  {
    Scanner stdin    = new Scanner (System.in);
    int line         = stdin.nextInt();
    int col          = stdin.nextInt();
    Cardinais matriz = new Cardinais(line, col);
    int tamanho      = 0;

    for(int i=0; i<matriz.line ; i++)
    {
      String n = stdin.next();
      for (int j=0; j<matriz.col; j++)
      {
        matriz.data[i][j] = n.charAt(j);
      }
    }

    tamanho = matriz.countSize();
    System.out.println(tamanho+" "+matriz.nvezes(tamanho));
    stdin.close();
  }
}
