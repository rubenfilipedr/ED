import java.util.Scanner;


class Palindromos {

  static String normalizar (String s1) {
    char c;                   // carater q vai assumir, um a um, cada carater da string s1
    int size = s1.length();   // tamanho da string s1
    String s2 = "";                // esta vai ser a tua string final
    for ( int i=0 ; i<size ; i++ ) {
      c = s1.charAt(i);
      if ( (c>='a' && c<='z') || (c>='A' && c<='Z') ) {     // se for letra
        s2 += s1.charAt(i);                        // a string final vai guardar essa letra                                                // guardar essa letra
      }                                                     // par ficares c uma string
    }                                                       // só c letras
    s2.toLowerCase();     // transformas as letras todas em minusculas
    return s2;
  }


  static void Final (String v) {
    int i = 0;                  // 1ª posição
    int size = v.length()-1;    // última posição
    while (i<size) {            // vais comparar a 1ª c a ultima posição, a 2ª c a penultima
      char c1 = v.charAt(i);    // e por assim adiante até metade da string
      char c2 = v.charAt(size);
      if ( c1 != c2 ) {             // por exemplo, se o 2º não for igual ao penultimo
        System.out.println("nao");  // ele diz "nao" e termina o programa, ou seja, não é
        return;                     // palindromo
      }
      i++;
      size--;
    }
    System.out.println("sim");      // se passar todos os testes, é palindromo
  }



  public static void main (String[] args) {
    Scanner stdin = new Scanner(System.in);
    String s1;
    while(stdin.hasNextLine()){
      s1 = stdin.nextLine();
      s1 = normalizar(s1);
      Final(s1);
    }
  }
}
