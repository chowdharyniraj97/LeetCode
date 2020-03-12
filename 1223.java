//https://leetcode.com/problems/dice-roll-simulation/
class Solution {
    HashMap<String,Integer> map;
    final long divisor = (long)Math.pow(10, 9) + 7;
    public int dieSimulator(int n, int[] rollMax) {
        map=new HashMap<>();
        String k="";
        long ans=0;
        for(int i=0;i<6;i++){
            ans=(ans+simulatedice(n-1,1,i,rollMax))%divisor;
        }
        return (int)ans;
    }
    
    
    public int simulatedice(int n,int count,int nos,int[] rollmax){
        if(n==0){
           // System.out.println(k);
            return 1;
            
        }
        if(map.containsKey(nos+" "+n+" "+count))
            return map.get(nos+" "+n+" "+count);
            
        long x=0;
        for(int i=0;i<6;i++){
            // if(nos==i && count==0)
            //     continue;
            if(i==nos && count<rollmax[i]){//handling consecutive case
            x=(x+simulatedice(n-1,count+1,i,rollmax)%divisor)%divisor;
            }
            else if(i!=nos)
                x=(x+simulatedice(n-1,1,i,rollmax)%divisor)%divisor;
        }
        map.put(nos+" "+n+" "+count,(int)x);
        return (int)x;
    }
}