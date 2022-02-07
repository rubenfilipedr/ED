public interface MyStack<T> {

  public void push(T v);
  public T pop();
  public void reverse(MyStack<Integer> s, int n);
  public boolean balanced(String s);

  public T top();
  public int size();
  public boolean isEmpty();
}
