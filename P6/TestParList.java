public class TestParList {
  public static void main (String[] args) {
    PairList<Integer> list = new PairList<>();

    System.out.println(list);
    System.out.println("isEmpty? " + list.isEmpty());
    for (int i=1 ; i<=3 ; i++) {
      for (int j=1 ; j<=3 ; j++) list.addLast(i,j);
    }
    System.out.println(list);
    System.out.println("Size = " + list.size());
    list.removeFirst();
    System.out.println(list);
    list.removeLast();
    System.out.println(list);
    System.out.println("isEmpty? " + list.isEmpty());
    System.out.println("getFirst() = " + list.getFirst());
    System.out.println("getLast() = " + list.getLast());
  }
}
