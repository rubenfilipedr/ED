class ED195 {

  public static boolean balanced(String s) {

    if (s.length()%2 != 0) return false;
    MyStack<Character> p = new LinkedListStack<>();
    for ( int i=0 ; i<s.length() ; i++ ) {
      if ( s.charAt(i)=='(' || s.charAt(i)=='[' ) {
        p.push(s.charAt(i));
      } else if ( (s.charAt(i)==')' && p.top()=='(') || (s.charAt(i)==']' && p.top()=='[') ) {
        p.pop();
      } else {
        return false;
      }
    }
    return true;

  }

}
