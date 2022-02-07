// Testando o metodo compareTo()
class TestCompare {
   public static void main(String[] args) {

      String s1 = "ana";
      String s2 = "carlos";
      String s3 = "adalberto";
      System.out.println("s1.compareTo(s1) = " + s1.compareTo(s1));
      System.out.println("s1.compareTo(s2) = " + s1.compareTo(s2));
      System.out.println("s1.compareTo(s3) = " + s1.compareTo(s3));

      System.out.println();

      Integer i1 = 23;
      Integer i2 = 10;
      Integer i3 = 42;
      System.out.println("i1.compareTo(i2) = " + i1.compareTo(i2));
      System.out.println("i1.compareTo(i3) = " + i1.compareTo(i3));
   }
}
