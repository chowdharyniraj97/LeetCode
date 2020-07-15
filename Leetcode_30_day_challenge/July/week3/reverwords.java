class Solution {
    public String reverseWords(String s) {
        String split[] = s.trim().split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = split.length-1; i > 0; i--){
            if(split[i].equals("")){
                continue;
            }
            sb.append(split[i] + " ");
        }
        sb.append(split[0]);
        return sb.toString();
        
    }
}
