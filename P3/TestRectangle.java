class Point {
  int x, y;

  Point() {
    x = y = 0;
  }

  Point(int x0, int y0) {
    x = x0;
    y = y0;
  }

  public String toString() {
    return "(" + x + "," + y + ")";
  }
}



class Rectangle {
  int X1, X2, Y1, Y2;

  Rectangle(int x1, int y1, int x2, int y2) {
    X1 = x1;
    X2 = x2;
    Y1 = y1;
    Y2 = y2;
  }

  Rectangle(Point p1, Point p2) {
    X1 = p1.x;
    X2 = p2.x;
    Y1 = p1.y;
    Y2 = p2.y;
  }

  int area() {
    int area = (X2-X1)*(Y2-Y1);
    return area;
  }

 int perimeter() {
    int perimeter = (2*(X2-X1)) + (2*(Y2-Y1));
    return perimeter;
  }

  boolean pointInside(Point p) {
    if ( (p.x>=X1 && p.x<=X2) && (p.y>=Y1 && p.y<=Y2) ) {
      return true;
    } else {
      return false;
    }
  }

  boolean rectangleInside(Rectangle r) {
    Point rp1 = new Point(r.X1,r.Y1);
    Point rp2 = new Point(r.X2,r.Y2);
    if ( pointInside(rp1) && pointInside(rp2) ) {
      return true;
    } else {
      return false;
    }
  }
  
}








class TestRectangle {
   public static void main(String[] args) {
      Point a = new Point(1,1);
      Point b = new Point(2,2);
      Point c = new Point(3,4);
      Point d = new Point(8,2);

      Rectangle amarelo  = new Rectangle(a, c);
      Rectangle laranja  = new Rectangle(2, 3, 9, 6);
      Rectangle verde    = new Rectangle(3, 4, 4, 5);
      Rectangle azul     = new Rectangle(5, 1, 6, 5);
      Rectangle vermelho = new Rectangle(7, 3, 9, 5);

      System.out.println("Perimetro do retangulo amarelo = " + amarelo.perimeter()); // 10
      System.out.println("Perimetro do retangulo laranja = " + laranja.perimeter()); // 20

      System.out.println("Area do retangulo amarelo = " + amarelo.area()); // 6
      System.out.println("Area do retangulo laranja = " + laranja.area()); // 21

      System.out.println("Ponto B dentro rectangulo amarelo? " + amarelo.pointInside(b)); // true
      System.out.println("Ponto D dentro rectangulo amarelo? " + amarelo.pointInside(d)); // false

      System.out.println("Retangulo verde dentro do laranja? " + laranja.rectangleInside(verde));       // true
      System.out.println("Retangulo azul dentro do laranja? " + laranja.rectangleInside(azul));         // false
      System.out.println("Retangulo vermelho dentro do laranja? " + laranja.rectangleInside(vermelho)); // true

   }
}
