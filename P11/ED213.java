// [ED213] Caminho de maior soma
// Deve devolver uma string contendo apenas caracteres 'E' e 'D' indicando o
// caminho de maior soma (percurso desde a raíz até uma folha onde a soma dos
// valores guardados nos nós seja a maior possível). 'E' significa esquerda e
// 'D' significa direita, pelo que algo como "EED" indica o caminho Raiz->Esquerda->Esquerda->Direita.
// Pode assumir que os nós contêm inteiros positivos e que existe sempre um único caminho de soma
// máxima com pelo menos dois nós para os casos que serão testados com o seu programa.

class ED213 {

  public static String maxSum(BTree<Integer> t) {
    String s = "";
    return maxSum(s, t.getRoot());
  }

  public static String maxSum(String s, BTNode<Integer> n) {
    if (n == null) return s;


  }

}
