class DoublyLinkedList<T> {
  private DNode<T> first;
  private DNode<T> last;
  private int size;

  DoublyLinkedList() {
    first = new DNode<T>(null, null, null);
    last = new DNode<T>(null, first, null);
    first.setNext(last);
    size = 0;
  }

  public int size() { return size; }

  public boolean isEmpty() { return (size == 0); }

  public T getFirst() {
    if (isEmpty()) return null;
    return first.getNext().getValue();
  }

  public T getLast() {
    if (isEmpty()) return null;
    return last.getPrev().getValue();
  }

  public void addBetween(T v, DNode<T> n1, DNode<T> n2) {
    DNode<T> newNode = new DNode<>(v, n1, n2);
    n1.setNext(newNode);
    n2.setPrev(newNode);
    size++;
  }

  public void addFirst(T v) {
    addBetween(v, first, first.getNext());
  }

  public void addLast(T v) {
    addBetween(v, last.getPrev(), last);
  }

  public void remove(DNode<T> n) {
    DNode<T> prev = n.getPrev();
    DNode<T> next = n.getNext();
    prev.setNext(next);
    next.setPrev(prev);
    size--;
  }

  public void removeFirst() {
    if (isEmpty()) return;
    remove(first.getNext());
  }

  public void removeLast() {
    if (isEmpty()) return;
    remove (last.getPrev());
  }

  public String toString() {
    String str = "{";
    DNode<T> cur = first.getNext();
    for (int i=0 ; i<size ; i++) {
      str += cur.getValue();
      cur = cur.getNext();
      if (cur != last) str += ",";
    }
    str += "}";
    return str;
  }

}
