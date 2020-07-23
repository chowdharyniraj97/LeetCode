//https://leetcode.com/problems/knight-probability-in-chessboard/
class Solution {
    HashMap<String,Double> map;
    public double knightProbability(int N, int K, int r, int c) {
        map=new HashMap<>();
        
        return compute(N,K,r,c);
        
            
    }
    
    double compute(int N,int K,int r,int c){
        if(r<0 || c<0 ||r>=N ||c>=N){
           // System.out.println("in");
            return 0;}
        if(K==0){
            //System.out.println("DSF");
            return 1;}
        if(map.containsKey(K+" "+r+" "+c))
            return map.get(K+" "+r+" "+c);
        double valid=0;
       // vis[r][c]=1
        valid+=compute(N,K-1,r-2,c+1)/8.0;
        valid+=compute(N,K-1,r-2,c-1)/8.0;
        valid+=compute(N,K-1,r-1,c+2)/8.0;
        valid+=compute(N,K-1,r+1,c+2)/8.0;
       // System.out.println("valid"+ valid);
        valid+=compute(N,K-1,r-1,c-2)/8.0;
        valid+=compute(N,K-1,r+1,c-2)/8.0;
        valid+=compute(N,K-1,r+2,c+1)/8.0;
        valid+=compute(N,K-1,r+2,c-1)/8.0;
        //System.out.println(valid)/8;
       // prob+=valid
        map.put(K+" "+r+" "+c,valid);
        return valid;
        
    }
}