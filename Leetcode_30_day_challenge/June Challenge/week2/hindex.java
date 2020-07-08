class Solution {
  public int hIndex(int[] citations) {
    int idx = 0, n = citations.length;
    for(int c : citations) {
      if (c >= n - idx) return n - idx;
      else idx++;
    }
    return 0;
  }
}
