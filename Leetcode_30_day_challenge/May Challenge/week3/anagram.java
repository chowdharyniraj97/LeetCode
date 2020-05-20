
class Solution {
    //O(26n) => O(n)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s == null || p == null || s.length() < p.length()) return ans;
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        int pLen = p.length();
        for(char c : p.toCharArray()){
            a1[c - 'a']++;
        }
        
        for(int i = 0; i < pLen; i++){
            char c = s.charAt(i);
            a2[c - 'a']++;
        }
        if(Arrays.equals(a1, a2)) ans.add(0);
        for(int i = pLen; i < s.length(); i++){
            char c = s.charAt(i);
            a2[c - 'a']++;
            c = s.charAt(i - pLen);
            a2[c - 'a']--;
            if(Arrays.equals(a1, a2)) ans.add(i - pLen + 1); //O(26)
        }
        return ans;
        
    }
}
