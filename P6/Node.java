public class Node<T> {
  private T value;
  private Node<T> next;

  Node (T v, Node<T> n) {
    value = v;
    next = n;
  }

  public T getValue() { return value; }

  public Node<T> getNext() { return next; }

  public void setValue (T v) { value = v; }

  public void setNext (Node<T> n) { next = n; }
  
}
