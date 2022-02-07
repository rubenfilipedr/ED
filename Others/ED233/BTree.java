public class BTree<T> {
  private BTNode<T> root; // raiz da arvore

  // Construtor
  BTree() {
    root = null;
  }

  // Getter e Setter para a raiz
  public BTNode<T> getRoot() {return root;}
  public void setRoot(BTNode<T> r) {root = r;}

  // Verificar se arvore esta vazia
  public boolean isEmpty() {
    return root == null;
  }

  // --------------------------------------------------------

  // Numero de nos da arvore
  public int numberNodes() {
    return numberNodes(root);
  }

  private int numberNodes(BTNode<T> n) {
    if (n == null) return 0;
    return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
  }

  // --------------------------------------------------------

  // Altura da arvore
  public int depth() {
    return depth(root);
  }

  private int depth(BTNode<T> n) {
    if (n == null) return -1;
    return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
  }

  // --------------------------------------------------------

  // O elemento value esta contido na arvore?
  public boolean contains(T value) {
    return contains(root, value);
  }

  private boolean contains(BTNode<T> n, T value) {
    if (n==null) return false;
    if (n.getValue().equals(value)) return true;
    return contains(n.getLeft(), value) || contains(n.getRight(), value);
  }

  // --------------------------------------------------------

  // Imprimir arvore em PreOrder
  public void printPreOrder() {
    System.out.print("PreOrder:");
    printPreOrder(root);
    System.out.println();
  }

  private void printPreOrder(BTNode<T> n) {
    if (n==null) return;
    System.out.print(" " + n.getValue() );
    printPreOrder(n.getLeft());
    printPreOrder(n.getRight());
  }

  // --------------------------------------------------------

  // Imprimir arvore em InOrder
  public void printInOrder() {
    System.out.print("InOrder:");
    printInOrder(root);
    System.out.println();
  }

  private void printInOrder(BTNode<T> n) {
    if (n==null) return;
    printInOrder(n.getLeft());
    System.out.print(" " + n.getValue());
    printInOrder(n.getRight());
  }

  // --------------------------------------------------------

  // Imprimir arvore em PostOrder
  public void printPostOrder() {
    System.out.print("PostOrder:");
    printPostOrder(root);
    System.out.println();
  }

  private void printPostOrder(BTNode<T> n) {
    if (n==null) return;
    printPostOrder(n.getLeft());
    printPostOrder(n.getRight());
    System.out.print(" " + n.getValue());
  }

  // --------------------------------------------------------

  // Imprimir arvore numa visita em largura (usando TAD Fila)
  public void printBFS() {
    System.out.print("BFS:");

    MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
    q.enqueue(root);
    while (!q.isEmpty()) {
      BTNode<T> cur = q.dequeue();
      if (cur != null) {
        System.out.print(" " + cur.getValue());
        q.enqueue(cur.getLeft());
        q.enqueue(cur.getRight());
      }
    }
    System.out.println();
  }

  // --------------------------------------------------------

  // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
  public void printDFS() {
    System.out.print("DFS:");

    MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
    q.push(root);
    while (!q.isEmpty()) {
      BTNode<T> cur = q.pop();
      if (cur != null) {
        System.out.print(" " + cur.getValue());
        q.push(cur.getLeft());
        q.push(cur.getRight());
      }
    }
    System.out.println();
  }

  // --------------------------------------------------------

  // Devolver a quantidade de nós internos da árvore
  public int internal() {
    return internal(root);
  }

  private int internal(BTNode<T> n) {
    if (n==null) return 0;
    if (n.getLeft()==null && n.getRight()==null) return 0;
    return 1 + internal(n.getLeft()) + internal(n.getRight());
  }

  // --------------------------------------------------------

  // Remover da árvore todos os nós com profundidade >= d
  public void cut(int d) {
    if (d<=0) {                          // Se a profundidade for menor ou igual a 0
      setRoot(null);                     // Árvore nula
    }
    if (d>depth()) return;               // Se d for maior que a profundidade da árvore não
                                         // há o que remover, logo 'return'
    cut(root, d);                        // Se passar as condições, chamamos o método recursivo
                                         // a partir da 'root'
  }

  private void cut(BTNode<T> n, int d) {
    if (n==null) return;                  // Se o nó for 'null', 'return'
    if (d==1) {                           // Se d == 1, significa que n está em d = 0,
      n.setLeft(null);                    // logo removemos o n.getRight() e o n-getLeft();
      n.setRight(null);
    } else {                              // Se d > 1, continuamos a chamar o método recursivo
      cut(n.getLeft(), d-1);              // Passando para o n.getRight() e n.getLeft(), porém
      cut(n.getRight(), d-1);             // Diminuindo o d até chegar ao caso base (d == 1)
    }
    return;
  }

  // --------------------------------------------------------

  // Devolver array [a,b], a -> quantidade máxima de nós num único nível
  // b -> quantidade de níveis com essa quantidade de nós
  public int[] maxLevel() {
    int max[] = {0, 0};                         // Array para guardar 'a' e 'b'
    int levels[] = new int[depth()+1];          // Array para guardar numero de nosmde cada nivel
    return maxLevel(root, levels, max, 0);
  }

  private int[] maxLevel(BTNode<T> n, int levels[], int max[], int i) {
    if (n==null) {                              // Se o nó for null
      return max;                               // retunr max
    } else {                                    // Se não for null
      levels[i] += 1;                           // Esse nível i, acrescenta um nó
    }

    if (levels[i] == max[0]) {                  // Se o nível atual tiver igual número de nós que o nível com mais nó até ao momento anterior
      max[1] += 1;                              // Posição 1 do array max, guarda 'b', ou seja, acrescenta mais um nível
    } else if (levels[i] > max[0]) {            // Se o nível atual tiver mais nós do que o nível com mais nós ate ao momento anterior
      max[0] = levels[i];                       // Posição 0 do array max, guarda 'a', ou seja, o número de nós no nível i
      max[1] = 1;                               // E passa a existir apenas um nível com esse número de nós
    } else { ; }

    maxLevel(n.getLeft(), levels, max, i+1);    // Recursividade para a subarvore da esquerda e subarvore da direita
    maxLevel(n.getRight(), levels, max, i+1);   // Com aumento do nível (i -> i+1)

    return max;
  }




}
