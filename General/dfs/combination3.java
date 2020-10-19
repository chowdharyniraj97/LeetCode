class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        combination(k,n,new ArrayList<>(),list,1);
        return list;
        
    }
    
    
    
    void combination(int k,int sum,List<Integer> temp, List<List<Integer>> list,int cur ) {
    
        if(sum == 0 && k==0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        if( k < 0 || sum<0)
            return;
        for(int i = cur ; i <10 ; i++) {
            temp.add(i);
            combination(k-1,sum - i,temp,list,i+1);
            temp.remove(temp.size() -1 );
            
        }
    }
}
