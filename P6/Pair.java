public class Pair<T> {
  private T x;
  private T y;
  private Pair<T> next;

  Pair(T v1, T v2, Pair<T> n) {
    x = v1;
    y = v2;
    next = n;
  }

  public T getX() { return x; }
  public T getY() { return y; }
  public Pair<T> getNext() { return next; }

  public void setX (T v) { x = v; }
  public void setY (T v) { y = v; }
  public void setNext (Pair<T> n) { next = n; }

  public String toString() {
    return "(" + x + "," + y + ")";
  }
}
