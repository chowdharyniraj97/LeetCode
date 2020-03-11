//https://leetcode.com/problems/dice-roll-simulation/

class Solution {
    HashMap<String,Integer> map;
    public int dieSimulator(int n, int[] rollMax) {
        map=new HashMap<>();
        String k="";
        int ans=0;
        for(int i=0;i<6;i++){
            ans+=simulatedice(n-1,rollMax[i]-1,i,rollMax,(i+1)+k);
        }
        return ans;
    }
    
    
    public int simulatedice(int n,int count,int nos,int[] rollmax,String k){
        if(n==0){
           // System.out.println(k);
            return 1;
            
        }
        if(map.containsKey(nos+" "+n+" "+count))
            return map.get(nos+" "+n+" "+count);
            
        int x=0;
        for(int i=0;i<6;i++){
            // if(nos==i && count==0)
            //     continue;
            if(i==nos && count>0){//handling consecutive case
            x+=simulatedice(n-1,count-1,i,rollmax,(i+1)+k);
            }
            else if(i!=nos)
                x+=simulatedice(n-1,rollmax[i]-1,i,rollmax,(i+1)+k);
        }
        map.put(nos+" "+n+" "+count,x);
        return x;
    }
}