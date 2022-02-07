public class TestSet {
   public static void main(String[] args) {
      IntSet s = new BooleanArrayIntSet(); // Cria um conjunto com espaco para 100 inteiros

      System.out.println(s);
      System.out.println(s.add(1));
      System.out.println(s.add(5));
      System.out.println(s.add(7));
      System.out.println(s);
      System.out.println(s.contains(1));
      System.out.println(s.contains(2));
      System.out.println(s.add(1));
      System.out.println(s.size());
      System.out.println(s.remove(5));
      System.out.println(s.remove(5));
      System.out.println(s);
      s.clear();
      System.out.println(s);
      System.out.println(s.size());
   }
}
