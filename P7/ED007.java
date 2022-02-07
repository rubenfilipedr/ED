import java.util.Scanner;

class ED007 {

  public static String balanced(String s) {
    int size = s.length();
    MyStack<Character> p = new LinkedListStack<>();
    for (int i=0 ; i<size ; i++) {
      if (s.charAt(i)=='(' || s.charAt(i)==')' || s.charAt(i)=='[' || s.charAt(i)==']') {
        if (s.charAt(i)=='(' || s.charAt(i)=='[') {
          p.push(s.charAt(i));
        } else if ( p.size()>0 && ((s.charAt(i)==')' && p.top()=='(') || (s.charAt(i)==']' && p.top()=='[')) ) {
          p.pop();
        } else { return ("Erro na posicao " + i); }
      }
    }
    if (p.size()>0) { return ("Ficam parenteses por fechar"); }
    return ("Expressao bem formada");
  }


  public static void main (String[] args) {
    MyStack<Character> p = new LinkedListStack<>();
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    scan.nextLine();
    for (int i=0 ; i<N ; i++) {
      String expr = scan.nextLine();
      System.out.println(balanced(expr));
    }
  }


}
