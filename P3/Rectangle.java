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
