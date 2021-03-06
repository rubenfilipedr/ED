public class SinglyLinkedList<T> {
  private Node<T> first;    // Primeiro no da lista
  private int size;         // Tamanho da lista

  // Construtor (cria lista vazia)
  SinglyLinkedList() {
    first = null;
    size = 0;
  }

  // Retorna o tamanho da lista
  public int size() {
    return size;
  }

  // Devolve true se a lista estiver vazia ou falso caso contrario
  public boolean isEmpty() {
    return (size == 0);
  }

  // Adiciona v ao inicio da lista
  public void addFirst(T v) {
    Node<T> newNode = new Node<T>(v, first);
    first = newNode;
    size++;
  }

  // Adiciona v ao final da lista
  public void addLast(T v) {
    Node<T> newNode = new Node<T>(v, null);
    if (isEmpty()) {
      first = newNode;
    } else {
      Node<T> cur = first;
      while (cur.getNext() != null)
      cur = cur.getNext();
      cur.setNext(newNode);
    }
    size++;
  }

  // Retorna o primeiro valor da lista (ou null se a lista for vazia)
  public T getFirst() {
    if (isEmpty()) return null;
    return first.getValue();
  }

  // Retorna o ultimo valor da lista (ou null se a lista for vazia)
  public T getLast() {
    if (isEmpty()) return null;
    Node<T> cur = first;
    while (cur.getNext() != null)
    cur = cur.getNext();
    return cur.getValue();
  }

  // Remove o primeiro elemento da lista (se for vazia nao faz nada)
  public void removeFirst() {
    if (isEmpty()) return;
    first = first.getNext();
    size--;
  }

  // Remove o ultimo elemento da lista (se for vazia nao faz nada)
  public void removeLast() {
    if (isEmpty()) return;
    if (size == 1) {
      first = null;
    } else {
      // Ciclo com for e uso de de size para mostrar alternativa ao while
      Node<T> cur = first;
      for (int i=0; i<size-2; i++)
      cur = cur.getNext();
      cur.setNext(cur.getNext().getNext());
    }
    size--;
  }

  // Converte a lista para uma String
  public String toString() {
    String str = "{";
    Node<T> cur = first;
    while (cur != null) {
      str += cur.getValue();
      cur = cur.getNext();
      if (cur != null) str += ",";
    }
    str += "}";
    return str;
  }

  // Devolver uma nova lista que ?? igual ?? lista original, mas invertida
  public SinglyLinkedList<T> reverse() {
    SinglyLinkedList<T> reverse = new SinglyLinkedList<T>();  // Nova lista (que ser?? a revertida)
    if (isEmpty()) { return reverse; }     // Se a original estiver vazia, retorna a revertida tambem vazia
    Node<T> cur = first;
    while (cur.getNext() != null) {        // Ciclo para percorrer a lista original
      reverse.addFirst(cur.getValue());    // Adicionar em primeiro ?? lista revertida (a partir da original)
      cur = cur.getNext();                 // Avan??ar na lista original
    }
    reverse.addFirst(cur.getValue());      // Adicionar ?? revertida o ??ltimo valor da lista original
    return reverse;
  }

  // Devolver array contendo as posi????es (por ordem crescente) de todas as ocorr??ncias
  public int[] occurrences(T elem) {
    if (isEmpty()) { return null; }     // Se a lista original estiver vazia retorna null
    int numOccur = 0;                   // Vari??vel que guarda o n??mero de ocurr??cnias do elemento recebido
    int occur[] = new int[size];        // Array com o tamanho m??ximo sendo o tamanho da lista original
                                        // para guardar as posi????es em que ocorre o elemento recebido
    int i, j = 0;                       // i representa as posi????es em que ocorre; j s??o as posi????es do array
    Node<T> cur = first;
    for (i=0 ; cur.getNext() != null ; i++) {
      if (cur.getValue().equals(elem)) {    // Se o valor correspondente na lista for igual ao elemento recebido
        occur[j++] = i;                     // Na posi????o j do vetor, guardamos o valor de i que representa em que
                                            // ocorreu o elemento. Incremento da posi????o a preencher no array
        numOccur++;                         // Incremento do n??mero de ocorr??ncias
      }
      cur = cur.getNext();                  // Avan??ar na lista original
    }
    if (cur.getValue().equals(elem)) {      // Se o ??ltimo valor da lista for igual ao elemento
      occur[j] = i;                         // (Mesmo processo utilizado anteriormente)
      numOccur++;
    }
    if (numOccur == 0) { return null; }     // Se o numero de ocorr??ncias for igual a 0 ?? porque o elemento n??o
                                            // apareceu na lista, logo retorna null
    else {
      int realOccur[] = new int[numOccur];  // Criar um novo array com o tamanho definitivo que seria o n??mero
                                            // de ocorr??ncias
      for (int k=0 ; k<numOccur ; k++) { realOccur[k] = occur[k]; } // Passar os valores para o novo array definitivo
      return realOccur;               // Retornar o array definitivo
    }
  }

  // Remover da lista todos os elementos que est??o na lista toRemove
  public void remove(SinglyLinkedList<T> toRemove) {
    Node<T> curToRemove = toRemove.first;   // Identificar o primeiro elemento da lista toRemove
    while (curToRemove.getNext()!=null) {   // Ciclo para percorrer a lista toRemove
      removeAll(curToRemove.getValue());    // Remover todas as ocorr??ncias do elemento marcado pelo N??
                                            // da lista original
      curToRemove = curToRemove.getNext();  // Avan??ar na lista toRemove
    }
    removeAll(curToRemove.getValue());      // Remover da lista original todas as ocorr??ncias do
                                            // ??ltimo elemnto da lista toRemove
  }


  public void removeAll(T value){           // M??todo j?? utilizado em exerc??cios anterior para remover todas
                                            // as ocorr??ncias do elemento recebido
    while ( !isEmpty() && first.getValue().equals(value) ) {    // Enquanto a lista n??o estiver vazia e
                                                                // o primeiro valor da lista for igual ao
                                                                // elemento recebido
      removeFirst();                                            // Remover o primeiro elemento da lista
    }
    Node<T> cur = first;
    while ( cur != null && cur.getNext() != null ) {            // Percorrer a lista
      while ( cur.getNext() != null && cur.getNext().getValue().equals(value) ) { // Enquanto o pr??ximo valor n??o
                                                                                  // for o fim da lista e for igual
                                                                                  // ao elemento recebido
        cur.setNext(cur.getNext().getNext());                                     // Defenir o pr??ximo elemento como sendo
                                                                                  // o "pr??ximo do pr??ximo"
        size--;                                                 // Atualizar o tamanho da lista
      }
      cur = cur.getNext();
    }
  }



}
