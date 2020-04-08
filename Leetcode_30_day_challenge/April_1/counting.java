class Solution {
    public int countElements(int[] arr) {
        HashSet<Integer> set=new HashSet<>();
        for(int k: arr)
            set.add(k);
        int count=0;
        for(int i : arr)
            if(set.contains(i+1))
                count++;
        return count;
    }
}