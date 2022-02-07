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


/*
class Rectangle {

  Rectangle(int x1, int x2, int y1, int y2) {
    Vie = Point(x1,y1);   // Vertice Inferior Esquerdo
    Vid = Point(x2,y1);   // Vertice Inferior Direito
    Vse = Point(x1,y2);   // Vertice Superior Esquerdo
    Vsd = Point(x2,y2);   // Vertice Superior Direito
  }

  Rectangle(Point p1, Point p2) {
    Vie = Point(p1.x,p1.y);   // Vertice Inferior Esquerdo
    Vid = Point(p2.x,p1.y);   // Vertice Inferior Direito
    Vse = Point(p1.x,p2.y);   // Vertice Superior Esquerdo
    Vsd = Point(p2.x,p2.y);   // Vertice Superior Direito
  }

  int area() {
    area = (Vid-Vie)*(Vsd-Vse);
    return area;
  }

  int perimeter() {
    perimeter = (2*(Vid-Vie)) + (2*(Vsd-Vse));
    return perimeter;
  }

  boolean pointInside(Point p) {
    if ( (p.x>=Vie && p.x<=Vid) && (p.y>=Vse && p.y<=Vsd) ) {
      return true;
    } else {
      return false;
    }
  }

  boolean rectangleInside(Rectangle r) {
    if ( pointInside() )
  }

}
*/





public class TestGeometry {
  public static void main (String[] args) {
    Point p1 = new Point();

    System.out.println("p1 original: " + p1);
    p1.x = 1;
    System.out.println("p1 modificado: " + p1);

    Point p2 = new Point(2,3);
    System.out.println("p2: " + p2);


  }
}
