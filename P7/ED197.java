class ED197 {
  public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b) {
    int smaller;
    MyQueue<Integer> ans = new LinkedListQueue<>();
    while ( !a.isEmpty() && !b.isEmpty() ) {
      if ( a.first()<=b.first() ) { smaller = a.dequeue(); }
      else { smaller = b.dequeue(); }
      ans.enqueue(smaller);
    }
    while ( !a.isEmpty() ) { ans.enqueue(a.dequeue()); }
    while ( !b.isEmpty() ) { ans.enqueue(b.dequeue()); }
    return ans;
  }
}
