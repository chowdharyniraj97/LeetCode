
class Solution {
    public int firstUniqChar(String s) {
        int ch[]=new int[26];
        int index[]=new int[26];
        int ans=Integer.MAX_VALUE;
        Arrays.fill(index,Integer.MAX_VALUE);
        int ind=0;
        for(char c : s.toCharArray()){
            ch[c-'a']++;
            index[c-'a']=Math.min(index[c-'a'],ind);
            ind++;
        }
        
        for(int i =0 ;i <26;i++){
            if(ch[i]==1)
            {
                ans=Math.min(ans,index[i]);
            }
        }
        
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
