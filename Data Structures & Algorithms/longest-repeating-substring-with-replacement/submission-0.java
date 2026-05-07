class Solution {
    public int characterReplacement(String s, int k) {
        if (s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        Map<Integer, Integer> counter = new HashMap<>();
        int ans = 0;
        int maxCharFreq = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            maxCharFreq = Math.max(maxCharFreq, counter.merge(s.charAt(r) - 'A', 1, Integer::sum));
            // The difference gives the number of characters to replace
            while (r - l + 1 - maxCharFreq > k) {
                counter.computeIfPresent(s.charAt(l) - 'A', (character, count) -> --count);
                l++; // Shrink the window from the left side until the number of characters to replace is less or equal to k
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
