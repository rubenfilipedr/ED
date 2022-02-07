// Exemplo de utilizacao da uma arvore binaria de pesquisa
// Ultima alteracao: 02/05/2018
// -----------------------------------------------------------

class TestBSTree {
   public static void main(String[] args) {

      // Criacao da Arvore
      BSTree<Integer> t = new BSTree<Integer>();

      // Inserindo 11 elementos na arvore binaria de pesquisa
      int[] data = {14, 4, 18, 3, 9, 16, 20, 7, 15, 17, 5};
      for (int i=0; i<data.length; i++) t.insert(data[i]);

      // Escrever resultado de chamada a alguns metodos
      System.out.println("numberNodes = " + t.numberNodes());
      System.out.println("depth = " + t.depth());
      System.out.println("contains(2) = " + t.contains(2));
      System.out.println("contains(3) = " + t.contains(3));

      // Escrever nos da arvore seguindo varias ordens possiveis
      t.printPreOrder();
      t.printInOrder();
      t.printPostOrder();

      // Experimentando remocao (passa a haver 10 elem)
      t.remove(14);
      t.printPreOrder();
      t.printInOrder();
      t.printPostOrder();

      System.out.println(t.minValue());
      System.out.println(t.maxValue());

      System.out.println(t.countBetween(0, 100));
   }
}
