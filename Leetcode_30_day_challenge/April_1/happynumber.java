class Solution {
    public boolean isHappy(int n) {
        if(n<10)
            n=n*n;
        HashSet<Integer> set=new HashSet<>();
        while(true){
            int temp=n;
            int sum=0;
            while(temp>0){
                int rem=temp%10;
                sum+=rem*rem;
                temp/=10;
            }
            if(set.contains(sum))
                return false;
            set.add(sum);
            if(sum==1)
                return true;
            n=sum;
        }
        
       
    }
}