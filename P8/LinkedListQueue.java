interface MyQueue<T> {

  // Metodos que modificam a fila
  public void enqueue(T v); // Coloca um valor no final da fila
  public T dequeue();       // Retira e retorna o valor no inicio da fila

  // Metodos que acedem a informacao (sem modificar)
  public T first();         // Retorna valor no inicio da fila
  public int size();        // Retorna quantidade de elementos na fila
  public boolean isEmpty(); // Indica se a fila esta vazia
}


public class LinkedListQueue<T> implements MyQueue<T> {
  private DoublyLinkedList<T> list;

  LinkedListQueue() { list = new DoublyLinkedList<T>();}

  public void enqueue(T v) { list.addLast(v); }
  public T dequeue() {
    T ans = list.getFirst();
    list.removeFirst();
    return ans;
  }
  public T first() { return list.getFirst();}
  public int size() {return list.size();}
  public boolean isEmpty() {return list.isEmpty();}

  public String toString() {return list.toString();}
}
