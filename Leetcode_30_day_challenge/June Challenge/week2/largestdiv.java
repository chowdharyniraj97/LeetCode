class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> best=new LinkedList<>();
        int size=0;
        Arrays.sort(nums);
         List<Integer> ans =null;
        // for(int i=0;i<nums.length;i++){
            
            ans = findbest(nums,0,1);
           // System.out.println(ans);
            // if(ans.size()>size){
            //     size=ans.size();
            //     best=ans;
        
        return ans;
            }
     
        
    
    
    List<Integer> findbest(int []nums,int cur,int big){
        if(cur==nums.length)
            return new LinkedList<>();
        
        List<Integer> x =new LinkedList<>();
        List<Integer> y =new LinkedList<>();
        List<Integer> z =new LinkedList<>();
        List<Integer> xz=new LinkedList<>();
        int temp=big;
        
        if(nums[cur]%big==0||big%nums[cur]==0){
            big=Math.max(big,nums[cur]);
            
            x=findbest(nums,cur+1,big);
            
            
           LinkedList<Integer> p=new LinkedList<>();
            
           for (int ele : x)
               p.add(ele);
            p.add(nums[cur]);
            LinkedList<Integer> q=new LinkedList<>();
            
            z=findbest(nums,cur+1,temp);            
           for (int ele : z)
               q.add(ele);
            
            xz=p.size()>q.size() ? p : q;
            
            
            
        }
        
        LinkedList<Integer> r =new LinkedList<>();
        y=findbest(nums,cur+1,temp);
        for (int ele : y)
               r.add(ele);
        
        //System.out.println(x+ " "+ y);
        
        if(r.size()>xz.size())
            return r;
        else
            return xz;
    }
}
