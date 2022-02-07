public interface MyQueue<T> {

  public void enqueue(T v);
  public T dequeue();

  public T first();
  public int size();
  public boolean isEmpty();

  public void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b);
  public MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b);
}
