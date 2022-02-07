class DNode<T> {
    private T value;          // Valor guardado no no
    private DNode<T> prev;    // Referencia para o no anerior
    private DNode<T> next;       // Referencia para o no seguinte

    DNode(T v, DNode<T> p, DNode<T> n) {  // Construtor
      value = v;
      prev = p;
      next = n;
    }

    // Getters e Setters
    public T getValue() { return value; }
    public DNode<T> getPrev() { return prev; }
    public DNode<T> getNext() { return next; }
    public void setValue(T v) { value = v; }
    public void setPrev(DNode<T> p) { prev = p; }
    public void setNext(DNode<T> n) { next = n; }
}


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


public class TestDoublyLinkedList {
  public static void main (String[] args) {

    // Criacao de lista de inteiros
     DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

     // Escrevendo lista (no inicio esta vazia)
     System.out.println(list);

     // Verificando se esta vazia
     System.out.println("isEmpty? " + list.isEmpty());

     // Adicionando numeros de 1 a 5 ao final da lista
     for (int i=1; i<=5; i++)
        list.addLast(i);
     System.out.println(list);

     // Adicionando numeros de 6 a 10 ao inicio da lista
     for (int i=6; i<=10; i++)
        list.addFirst(i);
     System.out.println(list);

     // Verificando o tamanho da lista
     System.out.println("size = " + list.size());

     // Retirando o primeiro elemento
     list.removeFirst();
     System.out.println(list);

     // Retirando o ultimo elemento
     list.removeLast();
     System.out.println(list);

     // Verificando se esta vazia
     System.out.println("isEmpty? " + list.isEmpty());

     // Escreve o primeiro e ultimo elementos
     System.out.println("getFirst() = " + list.getFirst());
     System.out.println("getLast() = " + list.getLast());

  }
}
