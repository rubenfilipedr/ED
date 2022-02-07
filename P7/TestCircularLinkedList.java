class Node<T> {
  private T value;
  private Node<T> next;

  Node(T v, Node<T> n) {
    value = v;
    next = n;
  }

  public T getValue() { return value; }
  public Node<T> getNext() { return next; }
  public void setValue(T v) { value = v; }
  public void setNext(Node<T> n) { next =n; }
}


class CircularLinkedList<T> {
   private Node<T> last; // Ultimo no da lista
   private int size;     // Tamanho da lista

   // Construtor (cria lista vazia)
   CircularLinkedList() {
      last = null;
      size = 0;
   }

   // Retorna o tamanho da lista
   public int size() { return size; }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() { return (size == 0); }

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty()) return null;
      return last.getNext().getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty()) return null;
      return last.getValue();
   }

   // Roda a lista (o primeiro passa a ser o novo ultimo da lista)
   public void rotate() {
      if (!isEmpty()) last = last.getNext();
   }

   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      if (isEmpty()) {
         last = new Node<T>(v, null);
         last.setNext(last); // Apontar para si proprio em "loop"
      } else {
         Node<T> newNode = new Node<T>(v, last.getNext());
         last.setNext(newNode);
      }
      size++;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      addFirst(v);
      last = last.getNext();
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
      if (size == 1) last = null;
      else last.setNext(last.getNext().getNext());
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty()) return;
      if (size == 1) {
         last = null;
      } else {
         Node<T> cur = last.getNext();
         for (int i=0; i<size-2; i++)
            cur = cur.getNext();
         last = cur;
         last.setNext(last.getNext().getNext());
      }
      size--;
   }

   // Converte a lista para uma String
   public String toString() {
      String str = "{";
      if (!isEmpty()) {
         Node<T> cur = last.getNext();
         for (int i=0; i<size; i++) {
            str += cur.getValue();
            if (cur != last) str += ",";
            cur = cur.getNext();
         }
      }
      str += "}";
      return str;
   }
}


public class TestCircularLinkedList {
   public static void main(String[] args) {

      // Simulando processos (A,B,C,D) e escalonamento round-robin
      // Criacao de lista de caracteres
      CircularLinkedList<Character> list = new CircularLinkedList<>();

      // Adicionando letras de 'A' a 'E'
      list.addLast('A');
      list.addLast('B');
      list.addLast('C');
      list.addLast('D');

      // Mostrando rotacao a funcionar
      System.out.println("8 rondas round-robin");
      for (int i=1; i<=8; i++) {
         System.out.println(i + ": " + list);
         list.rotate();
      }

      // Inserir e retirar elemento no final
      list.addLast('E');
      System.out.println("addLast('E'): " + list);
      list.removeLast();
      System.out.println("removeLast(): " + list);

      // Inserir retirar elemento no inicio
      list.addFirst('F');
      System.out.println("addFirst('F'): " + list);
      list.removeFirst();
      System.out.println("removeFirst(): " + list);

   }
}
