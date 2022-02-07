class ED196 {
  public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
    String name = "";
    String newList = "";
    while (q.size() > 0) {
      name += q.dequeue();
      newList += q.dequeue();
      if (newList.equals("A")) { a.enqueue(name); }
      else if (newList.equals("B")) { b.enqueue(name); }
      else {
        if ( a.size()>b.size() ) { b.enqueue(name); }
        else if ( a.size()<b.size() ) { a.enqueue(name); }
        else {}
      }
      name = "";
      newList = "";
    }

  }
}
