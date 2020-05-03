//http://leetcode.com/problems/backspace-string-compare


class Solution {
   public boolean backspaceCompare(String S, String T) {
        if (S.isEmpty() && T.isEmpty()) {
            return true;
        }
        int i = S.length() - 1;
        int j = T.length() - 1;

        while (true) {
            i = applyBackSpace(S, i);
            j = applyBackSpace(T, j);
            if (i < 0 && j < 0) {
                return true;
            }
            if (i < 0 || j < 0 || S.charAt(i--) != T.charAt(j--)) {
                return false;
            }
        }
    }

    private int applyBackSpace(String str, int i) {
        int count = 0;
        while (i >= 0) {
            if (str.charAt(i) == '#') {
                count++;
            } else if (count > 0) {
                count--;
            } else if (count == 0) {
                break;
            }
            i--;
        }
        return i;
    }
    
}