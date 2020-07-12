class Solution {
    public int hammingDistance(int x, int y) {
        String s1=Integer.toBinaryString(x);
         String s2=Integer.toBinaryString(y);
        System.out.println(s1+" "+s2);
        int l=s1.length()>s2.length() ? s2.length():s1.length();
        
        int p=s1.length()-1;
        int q=s2.length()-1;
        int count=0;
        for(int i=0;i<l;i++){
            if(s1.charAt(p--)!=s2.charAt(q--))
                count++;
        }
        System.out.println(count);
        System.out.println(q+ " "+p);
        while(p>=0){
            if(s1.charAt(p--)!=48)
                count++;
        }
        
         while(q>=0){
            if(s2.charAt(q--)!=48)
                count++;
        }
        
        return count;
    }
}
