import java.util.Scanner;

class Fraction {
  int num, dem;

  Fraction(int a, int b) {
    num = a;
    dem = b;
  }

  public String toString() {
    int u = num/dem;
    int r = num%dem;
    if (r == 0) {
      return u + "";
    } else {
      return u + " + " + r + "/" + dem;
    }
  }

  public Fraction add(Fraction f) {
    Fraction f1 = new Fraction(num,dem);
    if (dem != f.dem) {
      f1.num = (num * f.dem) + (f.num * dem);
      f1.dem = dem * f.dem;
    } else {
      f1.num = num + f.num;
    }
    return f1;
  }

  public Fraction multiply(Fraction f) {
    Fraction f1 = new Fraction(num,dem);
    f1.num = num * f.num;
    f1.dem = dem * f.dem;
    return f1;
  }

  public void simplify() {
    int a = num, b = dem, r;
    while (b != 0) {
      r = a%b;
      a = b;
      b = r;
    }
    num = num/a;
    dem = dem/a;
  }


}









class Fractional {

  public static void main(String[] args) {
    Scanner stdin = new Scanner(System.in);

    Fraction fr1 = new Fraction(stdin.nextInt(), stdin.nextInt());
    System.out.println(fr1);                 // Representação em texto no formato 'u + n/d'
    System.out.println();

    Fraction fr2 = new Fraction(stdin.nextInt(), stdin.nextInt());
    Fraction fr3 = new Fraction(stdin.nextInt(), stdin.nextInt());
    Fraction fr4 = fr2.add(fr3);                     // Nova fração = fr2 + fr3
    System.out.println(fr4.num + "/" + fr4.dem);
    System.out.println();

    Fraction fr5 = new Fraction(stdin.nextInt(), stdin.nextInt());
    Fraction fr6 = new Fraction(stdin.nextInt(), stdin.nextInt());
    Fraction fr7 = fr5.multiply(fr6);                      // Nova fração = fr5 * fr6
    System.out.println(fr7.num + "/" + fr7.dem);
    System.out.println();

    Fraction fr8 = new Fraction(stdin.nextInt(), stdin.nextInt());
    fr8.simplify();                                // Simplifica a fração introduzida
    System.out.println(fr8.num + "/" + fr8.dem);
    System.out.println();

  }

}
