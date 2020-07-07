class Solution {
    public String longestDupSubstring(String S) {
        int start = 0;
        int end = S.length() - 1;
        String result = "";
        while (start <= end) {
            int mid = (start + end) / 2;
            String dupSubstring = dupSubstring(S, mid); // check if any dupSubstring of mid size
            if (dupSubstring != null) {
                start = mid + 1;
                result = dupSubstring;
                return result;
            } else end = mid - 1;
        }

        return result;
    }

    private String dupSubstring(String s, int m) {
        int R = 31; // prime
        Map<Long, List<Integer>> map = new HashMap<>(); // why Map<Long, List<Integer>> ? with this we will keep index of all string of having same hash.

        long patHash = hash(s, m, R);
        map.putIfAbsent(patHash, new ArrayList());
        map.get(patHash).add(0);

        // pre-compute R^(m-1) % q for use in removing leading digit
        long RM = 1;
        for (int i = 1; i <= m - 1; i++)
            RM = (R * RM);

        for (int i = m; i < s.length(); i++) {
            // Remove leading digit, add trailing digit, check for match.
            patHash = (patHash - RM * s.charAt(i - m));
            patHash = (patHash * R + s.charAt(i));
            if (map.containsKey(patHash)) {
                for(int index: map.get(patHash)) 
                    if(s.substring(index, index + m).equals(s.substring(i - m + 1, i + 1)))
                        return s.substring(i - m + 1, i + 1);
            } 
            map.putIfAbsent(patHash, new ArrayList());
            map.get(patHash).add(i - m + 1);
        }

        return null;
    }

    private long hash(String s, int m, int R) {
        long h = 0;
        for (int j = 0; j < m; j++)
            h = (R * h + s.charAt(j));
        return h;
    }
}
