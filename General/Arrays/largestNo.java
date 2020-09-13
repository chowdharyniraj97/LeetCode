class mySort implements Comparator<String>{
    public int compare(String s1,String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        
        
        String ans1 = s1+s2;
        String ans2= s2+s1;
        int i =0;
        int j=0;
        while(i<len1+len2&&ans1.charAt(i)==ans2.charAt(j)){
            i++;
            j++;
        }
        if(i==len1+len2&&j==len1+len2)
            return 0;
        
        else{
            if(ans1.charAt(i)>ans2.charAt(j)){
                return -1;
            }
            else{
                return 1;
            }
        }
        
        
        
        
        
//         //--------------------
//         if(len1>len2){
//             int i=len1-len2;
//             int j=0;
//             while(s1.charAt(i)==s2.charAt(j)){
//                 i++;
//                 j++;
//             }
            
//             if(i==len1 && j==len2){
//               int c1 = s1.charAt(len2-1);
//               int c2 = s2.charAt(len2-1);
               
//               if(c1<c2)
//                   return 1;
//                else if(c1>c2)
//                    return -1;
//                 else
//                     return 0;
//             }
//             if(s1.charAt(i)>s2.charAt(j)){
//                 return -1;
//             }
//             else{
//                 return 1;
//             }
//         }
//         else{
//             int i=0;
//             int j=len2-len1;
//             while(s1.charAt(i)==s2.charAt(j)){
//                 i++;
//                 j++;
//             }
            
//             if(i==len1 && j==len2){
//               int c1 = s1.charAt(len1-1);
//               int c2 = s2.charAt(len1-1);
               
//               if(c1<c2)
//                   return 1;
//                else if(c1>c2)
//                    return -1;
//                 else
//                     return 0;
//             }
            
//             if(s1.charAt(i)>s2.charAt(j)){
//                 return -1;
//             }
//             else{
//                 return 1;
//             }
            
//         }
        
        
        
    }
}
class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue[] digits = new PriorityQueue[10];
        for(int s : nums){
            String x = String.valueOf(s);
            char c = x.charAt(0);
            if(digits[c-'0']==null){
                digits[c-'0']= new PriorityQueue<String>(new mySort());
                digits[c-'0'].add(x);
            }
            else{
                 digits[c-'0'].add(x);
            }
        }
        
        String ans="";
        for(int i=9;i>=0;i--){
            if(digits[i]!=null){
                PriorityQueue<String> pq = digits[i];
                while(!pq.isEmpty()){
                    String cur = pq.poll();
                    ans+=cur;
                }
            }
        }
        int z =0;
        if(ans.charAt(z)=='0')
            return "0";
        return ans;
    }
}

/*
firs tput numbers in bucket
sort buckets acc to rules
    1. compare length of two numbers
    2. if diff
        i. start comparing smaller and larger from smallers start pos


*/
