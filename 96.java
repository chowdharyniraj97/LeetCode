//https://leetcode.com/problems/unique-binary-search-trees/
class Solution {
    HashMap<Integer, Integer> map;
    public int numTrees(int n) {
        map=new HashMap<>();
       return countTrees(1,n);
    }
    
    int countTrees(int l,int h){
        if(l>=h)
            return 1;
        if(map.containsKey(h-l+1))
            return map.get(h-l+1);
        int sum=0;
        for(int i=l;i<=h;i++){
            sum+= countTrees(l,i-1)*countTrees(i+1,h);
        }
        map.put(h-l+1,sum);
        return sum;
    }
}