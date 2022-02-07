public class SinglyLinkedList<T> {
  private Node<T> first;
  private int size;

  SinglyLinkedList() {
    first = null;
    size = 0;
  }

  public int size() { return size; }

  public boolean isEmpty() { return (size == 0); }

  public void addFirst(T value) {
    Node<T> newNode = new Node<>(value, first);
    first = newNode;
    size++;
  }

  public void addLast(T value) {
    Node<T> newNode = new Node<>(value, null);
    if (isEmpty()) {
      first = newNode;
    } else {
      Node<T> cur = first;
      while (cur.getNext() != null) cur = cur.getNext();
      cur.setNext(newNode);
    }
    size++;
  }

  public T getFirst() {
    if (isEmpty()) return null;
    return (first.getValue());
  }

  public T getLast() {
    if (isEmpty()) return null;
    Node<T> cur = first;
    while (cur.getNext() != null) cur = cur.getNext();
    return (cur.getValue());
  }

  public void removeFirst() {
    if (isEmpty()) return;
    first = first.getNext();
    size--;
  }

  public void removeLast() {
    if (isEmpty()) return;
    if (size == 1) {
      first = null;
    } else {
      Node<T> cur = first;
      while ( cur.getNext().getNext() != null) cur = cur.getNext();
      cur.setNext(null);
    }
    size--;
  }

  public String toString() {
    String ans = "{";
    Node<T> cur = first;
    while (cur != null) {
      ans += cur.getValue();
      cur = cur.getNext();
      if (cur != null) ans += ",";
    }
    ans += "}";
    return ans;
  }

  public T get(int pos) {
    if (pos<0 || pos>=size) return null;
    Node<T> cur = first;
    for (int i=0 ; i<pos ; i++) cur = cur.getNext();
    return cur.getValue();
  }

  public T remove(int pos) {
    if (pos < 0 || pos >= size) return null;
    Node <T> cur = first;
    T k;
    if (pos == 0) {
      k = cur.getValue();
      removeFirst();
    } else {
      for (int i=0 ; i<(pos-1) ; i++) cur = cur.getNext();
      k = cur.getNext().getValue();
      cur.setNext(cur.getNext().getNext());
      size--;
    }
    return k;
  }

  public SinglyLinkedList<T> copy() {
    SinglyLinkedList<T> newList = new SinglyLinkedList<>();
    Node<T> cur = first;
    for (int i=0 ; i<size ; i++) {
      newList.addLast(cur.getValue());
      cur = cur.getNext();
    }
    return newList;
  }

  public void duplicate() {
    Node<T> cur = first;
    while (cur != null) {
      Node<T> n = new Node<>(cur.getValue(), cur.getNext());
      cur.setNext(n);
      cur = cur.getNext().getNext();
      size++;
    }
  }

  public int count(T value) {
    Node<T> cur = first;
    int count = 0;
    while (cur != null) {
      T v1 = cur.getValue();
      if (v1.equals(value)) { count++; }
      cur = cur.getNext();
    }
    return count;
  }

  public void removeAll(T value){
    while ( !isEmpty() && first.getValue().equals(value) ) {
      removeFirst();
    }
    Node<T> cur = first;
    while ( cur != null && cur.getNext() != null ) {
      while ( cur.getNext() != null && cur.getNext().getValue().equals(value) ) {
        cur.setNext(cur.getNext().getNext());
        size--;
      }
      cur = cur.getNext();
    }
  }

}
