public class TestMyQueue {
  public static void main (String[] args) {

    // Criacao da fila
      MyQueue<Integer> q = new LinkedListQueue<>();

      // Exemplo de insercao de elementos na fila
      for (int i=1; i<=8; i++)
         q.enqueue(i); // insere i no final da fila
      System.out.println(q);

      // Exemplo de remocao de elementos da fila
      for (int i=0; i<4; i++) {
         int aux = q.dequeue(); // retira o elemento no inicio da fila
         System.out.println("q.dequeue() = " + aux);
      }
      System.out.println(q);

      // Exemplo de utilizacao dos outros metodos
      System.out.println("q.size() = " + q.size());
      System.out.println("q.isEmpty() = " + q.isEmpty());
      System.out.println("q.first() = " + q.first());

      MyQueue<String> x = new LinkedListQueue<>();
      x.enqueue("Luis");
      x.enqueue("B");
      x.enqueue("Pedro");
      x.enqueue("A");
      x.enqueue("Luisa");
      x.enqueue("A");
      x.enqueue("Joao");
      x.enqueue("X");
      x.enqueue("Jose");
      x.enqueue("X");
      x.enqueue("Miguel");
      x.enqueue("B");
      MyQueue<String> a = new LinkedListQueue<>();
      MyQueue<String> b = new LinkedListQueue<>();
      q.process(x, a, b);
      System.out.println(x);
      System.out.println(a);
      System.out.println(b);

      MyQueue<Integer> result = new LinkedListQueue<>();
      MyQueue<Integer> a1 = new LinkedListQueue<>();
      a1.enqueue(2);
      a1.enqueue(4);
      a1.enqueue(8);
      a1.enqueue(10);
      a1.enqueue(11);
      a1.enqueue(15);
      MyQueue<Integer> b1 = new LinkedListQueue<>();
      b1.enqueue(1);
      b1.enqueue(4);
      b1.enqueue(9);
      result = result.merge(a1, b1);
      System.out.println(result);
  }
}
