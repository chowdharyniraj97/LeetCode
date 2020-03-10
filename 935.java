//https://leetcode.com/problems/knight-dialer/
class Solution {
    HashMap<String,Integer> map;
    public int knightDialer(int N) {
        map=new HashMap<>();
        int count=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(i*3+j==9 || i*3+j==11)
                    continue;
                int nos=i*3+j+1;
                count=(count+compute(i,j,N-1,"")) % (1000000000+7);
            }
        }
        return count;
    }
    
    int compute(int r,int c,int N,String ans){
        if(r>=4 || c>=3 || r<0 || c<0 || r*3+c==9 || r*3+c==11)
            return 0;
        if(N==0){
            //System.out.println(ans+(r*3+c+1));
            return 1;}
        if(map.containsKey(r+" "+c+" "+N))
            return map.get(r+" "+c+" "+N);
        int valid=0;
        int nos=r*3+c+1;
        valid=(valid+compute(r-2,c+1,N-1,ans+nos)) % (1000000000+7);
        valid=(valid+compute(r-2,c-1,N-1,nos+""))%(1000000000+7);
        valid=(valid+compute(r-1,c+2,N-1,nos+""))%(1000000000+7);
        valid=(valid+compute(r+1,c+2,N-1,nos+""))%(1000000000+7);
        valid=(valid+compute(r-1,c-2,N-1,nos+""))%(1000000000+7);
        valid=(valid+compute(r+1,c-2,N-1,nos+""))%(1000000000+7);
        valid=(valid+compute(r+2,c+1,N-1,nos+""))%(1000000000+7);
        valid=(valid+compute(r+2,c-1,N-1,nos+""))%(1000000000+7);
        map.put(r+" "+c+" "+N,valid);
            return valid;
    }
}