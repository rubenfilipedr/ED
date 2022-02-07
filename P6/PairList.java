public class PairList<T> {
  private Pair<T> first;
  private int size;

  PairList() {
    first = null;
    size = 0;
  }

  public int size() { return size; }

  public boolean isEmpty() { return (size == 0); }

  public void addFirst(T v1, T v2) {
    Pair<T> newPair = new Pair<>(v1, v2, first);
    first = newPair;
    size++;
  }

  public void addLast(T v1, T v2) {
    Pair<T> newPair = new Pair<T>(v1, v2, null);
    if (isEmpty()) {
      first = newPair;
    } else {
      Pair<T> cur = first;
      while (cur.getNext() != null) cur = cur.getNext();
      cur.setNext(newPair);
    }
    size++;
  }

  public Pair<T> getFirst() {
    if (isEmpty()) return null;
    return first;
  }

  public Pair<T> getLast() {
    if (isEmpty()) return null;
    Pair<T> cur = first;
    while (cur.getNext() != null) cur = cur.getNext();
    return cur;
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
      Pair<T> cur = first;
      while (cur.getNext().getNext() != null) cur = cur.getNext();
      cur.setNext(null);
    }
    size--;
  }

  public String toString() {
    String ans = "{";
    Pair<T> cur = first;
    while (cur != null) {
      ans += cur;
      cur = cur.getNext();
      if (cur != null) ans += ",";
    }
    ans += "}";
    return ans;
  }




}
