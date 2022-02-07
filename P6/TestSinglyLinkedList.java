public class TestSinglyLinkedList {
  public static void main (String[] args) {

    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    System.out.println(list);
    System.out.println("isEmpty? " + list.isEmpty());
    for (int i=1 ; i<=5 ; i++) list.addLast(i);
    System.out.println(list);
    for (int i=6 ; i<=10 ; i++) list.addFirst(i);
    System.out.println(list);
    System.out.println("Size = " + list.size());
    list.removeFirst();
    System.out.println(list);
    list.removeLast();
    System.out.println(list);
    System.out.println("isEmpty? " + list.isEmpty());
    System.out.println("getFirst() = " + list.getFirst());
    System.out.println("getLast() = " + list.getLast());
    System.out.println("get(0) = " + list.get(0));
    System.out.println("get(1) = " + list.get(1));
    System.out.println("get(2) = " + list.get(2));
    System.out.println("get(3) = " + list.get(3));
    System.out.println("get(-1) = " + list.get(-1));


  }
}
