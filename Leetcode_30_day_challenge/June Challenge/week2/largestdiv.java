class Solution {
  HashMap<Integer, List<Integer>> _eds = new HashMap<Integer, List<Integer>>();
  int [] _nums = {};

  private List<Integer> EDS(Integer i) {
    // memoization
    if (this._eds.containsKey(i)) return this._eds.get(i);
      
    List<Integer> maxSubset = new ArrayList();
    // Find the largest divisible subset of previous elements.
    for (int k = 0; k < i; ++k) {
      if (this._nums[i] % this._nums[k] == 0) {
        List<Integer> subset = EDS(k);
        if (maxSubset.size() < subset.size()) maxSubset = subset;
      }    
    }
    // Extend the found subset with the element itself.
    List<Integer> newEntry = new ArrayList();
    newEntry.addAll(maxSubset);
    newEntry.add(this._nums[i]);

    // update the cached values
    this._eds.put(i, newEntry);
    return newEntry;
  }

  public List<Integer> largestDivisibleSubset(int[] nums) {
    // Test case with empty set.
    int n = nums.length;
    if (n == 0) return new ArrayList();
        
    // Container to keep the largest divisible subset
    //   that ends with each of the nums
    // key: the index of the element
    this._eds = new HashMap<Integer, List<Integer>>();
    
    /* Sort the original list in ascending order. */
    Arrays.sort(nums);
    this._nums = nums;
    
    List<Integer> maxSubset = new ArrayList();    
    /* Calculate the values of all EDS(X_i), 
       while keeping track of the largest one as the result value. */
    for (int i = 0; i < n; ++i) {
      List<Integer> subset = EDS(i);
      if (maxSubset.size() < subset.size()) maxSubset = subset;
    }
    
    // return the largest one
    return maxSubset;
  }
}
