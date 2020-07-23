// copy the below soltuion to leetcode problem 650
//https://leetcode.com/problems/2-keys-keyboard/
// recursive + DP solution


class Solution {
    public int minSteps(int n) {
        if(n==1)//trival case 
            return 0;
        //the reason i have added 2 below is because my start case is 'AA' and not A as
        //one has to copy and paste the single 'A' to start with thus that 2 is added
        return 2+findsteps(n, 2, 1);
    }
    
    
    int findsteps(int n,int cur,int prev){// cur-->current A's on screen and prev-->number of A's from last screen
                                                                                                
        if(cur==n)
            return 0;
        if(cur>n)
            return Integer.MAX_VALUE;
        
        int a=findsteps(n,cur*2,cur);// it means we are copy and pasting the A currently on our screen
        int b=findsteps(n,cur+prev,prev);// we are using the A from previous screen and pasting it 
        
        //below we add 2 to variable a and 1 to variable b in the else part bcoz:
                // for variable a' recursive call we are perform copy and paste thus 2 steps
    // for variable b's recursive call we are only pasting the A's which we had from our last copy thus 1
        
        
        if(a==Integer.MAX_VALUE && b==Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(a==Integer.MAX_VALUE)
            return b+1;
        else if(b==Integer.MAX_VALUE)
            return a+2;
        else
            return Math.min(2+a,1+b);
    }
}

//---------------------------------------------Dp Solution ---------------------------------------------------

class Solution{
     
public int minSteps(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i-1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i/j);
                    break;
                }
                
            }
        }
        return dp[n];
    }
}