class MyIntSet implements IntSet {
  private int size;
  private boolean isElem[];
  private int maxSize;

  MyIntSet () {
    isElem = new boolean[1000];
    size = 0;
    maxSize = 1000;
  }

  MyIntSet (int maxSize) {
    isElem = new boolean[maxSize];
    size = 0;
    this.maxSize = maxSize;
  }



  public boolean add(int x) {
     if (isElem[x]==false) {
        isElem[x] = true;
        size++;
        return true;
     }
     return false;
  }

  public boolean remove(int x) {
     if (isElem[x]==true) {
       isElem[x] = false;
       size--;
       return true;
     }
     return false;
  }


  public boolean contains(int x) {
     if (isElem[x]==true) return true;
     return false;
  }

  public void clear() {
    for (int i=0 ; i<maxSize ; i++) {
      isElem[i] = false;
    }
    size = 0;
  }

  public int size() {
     return size;
  }

  public String toString() {
     String res = "{";
     int k = 0;
     for (int i=0; i<maxSize; i++) {
        if (isElem[i]==true) {
          if (k>0) res += ',';
          k++;
          res += i;
        }
     }
     res += "}";
     return res;
  }




}
