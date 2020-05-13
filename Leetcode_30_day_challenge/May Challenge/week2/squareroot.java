
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==0)
            return false;
        
        double sqrt=Math.sqrt(num);
        double in=Math.floor(sqrt);
        
        return sqrt/in ==1.0;
    }
}
