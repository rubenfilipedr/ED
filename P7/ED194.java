class ED194 {
  public static void reverse(MyStack<Integer> s, int n) {
    int v[] = new int[s.size()];
    for (int i=0 ; i<n ; i++) {
      v[i] = s.pop();
    }
    for (int i=0 ; i<n ; i++) {
      s.push(v[i]);
    }
  }
}
