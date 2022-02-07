// [ED211] Contando os números pares
// Deve devolver a quantidade de números pares que são elementos da árvore.
// Pode assumir que todos os valores são inteiros positivos.

class ED211 {

  public static int countEven(BTree<Integer> t) {
    return countEven(t.getRoot());
  }

  public static int countEven(BTNode<Integer> n) {
    if (n == null) return 0;
    if (n.getValue()%2 == 0) return 1 + countEven(n.getLeft()) + countEven(n.getRight());
    return 0 + countEven(n.getLeft()) + countEven(n.getRight());
  }

}
