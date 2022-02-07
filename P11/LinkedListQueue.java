public class LinkedListQueue<T> implements MyQueue<T> {
  private DoublyLinkedList<T> list;

  LinkedListQueue() { list = new DoublyLinkedList<T>(); }

  public void enqueue(T v) { list.addLast(v); }

  public T dequeue() {
    T ans = list.getFirst();
    list.removeFirst();
    return ans;
  }

  public T first() { return list.getFirst(); }

  public int size() { return list.size(); }

  public boolean isEmpty() { return list.isEmpty(); }

  public String toString() { return list.toString(); }

  public void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
    String name = "";
    String newList = "";
    while (q.size() > 0) {
      name += q.dequeue();
      newList += q.dequeue();
      if (newList.equals("A")) { a.enqueue(name); }
      else if (newList.equals("B")) { b.enqueue(name); }
      else {
        if ( a.size()>b.size() ) { b.enqueue(name); }
        else if ( a.size()<b.size() ) { a.enqueue(name); }
        else {}
      }
      name = "";
      newList = "";
    }
  }

  public MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {
    int smaller;
    MyQueue<Integer> ans = new LinkedListQueue<>();
    while ( !a.isEmpty() && !b.isEmpty() ) {
      if ( a.first()<=b.first() ) { smaller = a.dequeue(); }
      else { smaller = b.dequeue(); }
      ans.enqueue(smaller);
    }
    while ( !a.isEmpty() ) { ans.enqueue(a.dequeue()); }
    while ( !b.isEmpty() ) { ans.enqueue(b.dequeue()); }
    return ans;
  }

}
