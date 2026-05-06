class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Character 32: ' '
        // Character 126: '~'
        int m = 95;
        int[] counter = new int[m];
        Arrays.fill(counter, -1);
        int n = s.length();
        char space = ' ';
        int ans = 0;
        int current = 0;
        int i = 0;
        while (i < n) {
            int index = s.charAt(i) - space;
            if (counter[index] >= 0) {
                ans = Math.max(ans, current);
                current = 1;
                i = counter[index] + 1; // Move to the character next to the previous duplicate
                if (i < n) {
                    counter = new int[m];
                    Arrays.fill(counter, -1);
                    index = s.charAt(i) - space;
                    counter[index] = i;
                }
            } else {
                current++;
                ans = Math.max(ans, current);
                counter[index] = i;
            }
            i++;
        }
        return ans;
    }
}
