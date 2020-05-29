class Solution {
    public int[] countBits(int num) {
        int ans[]=new int[num+1];
        if(num<2)
        {
            if(num==0)
                return new int[]{0};
            else
                return new int[]{0,1};
        }
       ans[0]=0;
        ans[1]=1;
        int target=0;
        for(int i=2;i<=num;i++){
            if((i &(i-1))==0){
                ans[i]=1;
                target=i;
                continue;
            }
            
            int diff=i-target;
            ans[i]=1+ans[diff];
        }
        
        return ans;
    }
}
