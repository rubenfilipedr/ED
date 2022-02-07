public class LinkedListStack<T> implements MyStack<T> {
  private DoublyLinkedList<T> list;

  LinkedListStack() { list = new DoublyLinkedList<T>(); }

  public void push(T v) { list.addFirst(v); }

  public T pop() {
    T ans = list.getFirst();
    list.removeFirst();
    return ans;
  }

  public void reverse(MyStack<Integer> s, int n) {
    int v[] = new int[s.size()];
    for (int i=0 ; i<n ; i++) {
      v[i] = s.pop();
    }
    for (int i=0 ; i<n ; i++) {
      s.push(v[i]);
    }
  }

  public boolean balanced(String s) {
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

  public T top() { return list.getFirst(); }

  public int size() { return list.size(); }

  public boolean isEmpty() { return list.isEmpty(); }

  public String toString() { return list.toString(); }
}
