class Solution {
    List<List<Integer>> ans;
    HashSet<ArrayList<Integer>> set;
    public List<List<Integer>> subsets(int[] nums) {
        ans=new ArrayList<>();
       set=new HashSet<>();
        ArrayList<Integer> list= new ArrayList<>();
        for(int num:nums)
            list.add(num);
        findallsubsets(list,nums,0,nums.length-1,0);
       if(!ans.contains(new ArrayList<>()))
            ans.add(new ArrayList<>());
        return ans;
    }
    
    void findallsubsets(ArrayList<Integer> cur,int nums[],int start,int end,int index){
       // System.out.println();
        // if(cur.size()==1 && !ans.contains(cur)){
        //     ArrayList<Integer> empty=new ArrayList<>();
        //     empty.add(cur.get(0));
        //     ans.add(empty);
        //     return;
        //     //set.add(empty);
        // }
        if(index>=cur.size() && !set.contains(cur)){
           // System.out.println("!");
            // for(int e:cur)
            //     System.out.print(e+"-");
            ArrayList<Integer> x=new ArrayList<>(cur);
            ans.add(x);
            set.add(x);
            return;
        }
        if(index>=cur.size())
            return;
        // //ArrayList<Integer> l1=new ArrayList<>();
        // for(int ele:cur)
        //     l1.add(ele);
        
         ArrayList<Integer> temp=new ArrayList<>();
        for(int ele:cur)
        {//System.out.print(ele+" ");
           temp.add(ele);}
        
        findallsubsets(temp,nums,start,end,index+1);
        
      
          
        temp.remove(index);
        
        findallsubsets(temp,nums,0,temp.size(),0);
        
        //cur=temp;
        
    
    
    }
            
}
