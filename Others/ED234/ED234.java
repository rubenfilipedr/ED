/*
Nome: Rúben Filipe Dourado Rodrigues
Número mecanográfico: 201904870
Sobre ajudas: Neste exercicio visualizei o código apresentado nos slides e as "dicas" dadas pelo professor
              no enunciado do problema.
Explicação da solução:
                       - Método "firstFlag": Através de uma árvore binária de pesquisa de "String",
                        inserimos o nome dos filmes, e através do método já implementado anteriormente
                        "insert()" que insere na árvore apenas os filmes que ainda não foram adicionados.
                        No final apenas é necessário utilizar o método "numberNodes()" que nos indica o
                        número de nós da árvore, sendo neste caso, o número de filmes com pelos menos uma
                        avaliação.
                       - Complexidade O(N^2), pois é necessário adicionar N filmes e para cada filme é
                       necessário verificar se a árvore já contém o elemento.

                       - Método "secondFlag": Uśamos uma BSTMap para guardar as chaves (nome dos filmes)
                       e os valores (número de avaliações). Caso o valor correspondente à chave seja 'null'
                       é porque o filme ainda não foi adicionado e adicionámo-lo com apenas 1 avaliação. A
                       cada ocorrência do nome do filme acrescentámos +1 ao valor pois representa o número
                       de avaliações recebidas. No final percorre-se a lista ligada com os valores e
                       identifica-se o valor máximo, e a chave correspondente (nome do filme).
                       - Complexidade O(N), sendo N o número de avaliações.

                       - Método "thirdFlag": Foram criadas 2 BSTMap, uma para guardar a soma das avaliações
                       de cada filme e no final guardar a média de avaliações (average), e outra para ir
                       guardando o número de avaliações de cada filme (numberEval). A árvore numberEval segue
                       o principio utilizado no método "secondFlag" (já explicado), enquanto que a árvore
                       average, apesar de ser um principio semelhante, guarda para cada filme a soma de todas
                       as avaliações relativamente a esse filme. Deste modo, é possível saber a média das
                       avaliações de cada filme divindo os "values" de average por numberEval, guardando o
                       quociente desta divisão na árvore average. Através de uma condição verificamos a média
                       de avaliação de cada filme e caso seja >=5 imprimimos o nome do mesmo.
                       - Complexidade O(N). sendo N o número de avaliações.

Espero ter-me conseguido expressar da melhor forma. Obrigado.
*/


import java.util.Scanner;
import java.util.LinkedList;


class ED234 {


  public static void firstFlag(int N, Scanner scan) {
    BSTree<String> t = new BSTree<>();
    for (int i=0 ; i<N ; i++) {
      t.insert(scan.next());
      scan.nextInt();
    }
    System.out.println(t.numberNodes());
  }


  public static void secondFlag(int N, Scanner scan) {
    BSTMap<String,Integer> map = new BSTMap<>();
    String film = "";
    int max = 0;
    for (int i=0 ; i<N ; i++) {
      String line = scan.nextLine();
      String[] names = line.split(" ");
      Integer k = map.get(names[0]);
      if (k == null) { map.put(names[0], 1); }
      else { map.put(names[0], k+1); }
    }
    LinkedList<String> names = map.keys();
    for (String s : names) {
      if (map.get(s) > max) {
        max = map.get(s);
        film = s;
      }
    }
    System.out.println(film + " " + max);
  }


  public static void thirdFlag(int N, Scanner scan) {
    BSTMap<String,Integer> average = new BSTMap<>();
    BSTMap<String,Integer> numberEval = new BSTMap<>();
    for (int i=0 ; i<N ; i++) {
      String line = scan.nextLine();
      String[] names = line.split(" ");
      Integer k = average.get(names[0]);
      Integer p = numberEval.get(names[0]);
      if (k == null) {
        average.put(names[0], Integer.parseInt(names[1]));
        numberEval.put(names[0], 1);
      } else {
        average.put(names[0], k+Integer.parseInt(names[1]));
        numberEval.put(names[0], p+1);
      }
    }
    LinkedList<String> names = average.keys();
    for (String s : names) {
      average.put(s, average.get(s)/numberEval.get(s));
      if (average.get(s) >= 5) System.out.println(s);
    }
  }


  public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);
    int F = scan.nextInt();         // Flag que define a tarefa a executar
    int N = scan.nextInt();         // Número de avaliações
    scan.nextLine();
    if (F == 1) firstFlag(N, scan);
    if (F == 2) secondFlag(N, scan);
    if (F == 3) thirdFlag(N, scan);
  }


}
