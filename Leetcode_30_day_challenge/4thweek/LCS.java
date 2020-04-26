class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int ans[]=new int[m+1];
        int prev=0;
        char t1[]=text1.toCharArray();
        char t2[]=text2.toCharArray();
        int t=0;
        for(int i=1;i<=n;i++){
            t=0;
            for(int j=1;j<=m;j++)
            {
                prev=ans[j];
                if(t1[i-1]==t2[j-1]){
                    
                    ans[j]=1+t;
                }
                else{
                    ans[j]=Math.max(ans[j],ans[j-1]);
                }
                t=prev;
            }
            // for( int k=0;k<m;k++)
            //     System.out.print(ans[k]);
            // System.out.println();
        }
        return ans[m];
    }
}