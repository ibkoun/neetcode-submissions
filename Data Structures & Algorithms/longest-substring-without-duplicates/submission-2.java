class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Character 32: ' '
        // Character 126: '~'
        Map<Integer, Integer> counter = new HashMap<>();
        int n = s.length();
        char space = ' ';
        int ans = 0;
        int current = 0;
        int i = 0;
        while (i < n) {
            int index = s.charAt(i) - space;
            if (counter.containsKey(index)) {
                ans = Math.max(ans, current);
                current = 1;
                i = counter.get(index) + 1; // Move to the character next to the previous duplicate
                if (i < n) {
                    counter = new HashMap<>();
                    index = s.charAt(i) - space;
                    counter.put(index, i);
                }
            } else {
                current++;
                ans = Math.max(ans, current);
                counter.put(index, i);
            }
            i++;
        }
        return ans;
    }
}
