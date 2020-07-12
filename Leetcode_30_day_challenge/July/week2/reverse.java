public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long ans = 0 , pow = 31;
        for(int i=0;i<32;i++){
            ans += (n&1)<<pow;
            n >>= 1;
            pow--;
        }
        return (int)ans;
    }
}
