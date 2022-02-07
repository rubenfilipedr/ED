// [ED212] Soma de todos os níveis
// Deve um array contendo a soma dos nós de cada nível.
// O array deverá ter tamanho igual ao número de níveis e ter as somas do primeiro para o último nível.

class ED212 {

  public static int[] sumLevels(BTree<Integer> t) {
    int levels[] = new int[t.depth()+1];
    return sumLevels(levels, 0, t.getRoot());
  }

  public static int[] sumLevels(int[] v, int i, BTNode<Integer> n) {
    if (n == null) return v;
    else v[i] += n.getValue();

    sumLevels(v, i+1, n.getRight());
    sumLevels(v, i+1, n.getLeft());

    return v;
  }



}
