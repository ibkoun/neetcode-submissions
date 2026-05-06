class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Character 32: ' '
        // Character 126: '~'
        Map<Integer, Integer> indices = new HashMap<>();
        int n = s.length();
        char space = ' ';
        int ans = 0;
        int i = -1;
        int j = 0;
        while (j < n) {
            int index = s.charAt(j) - space;
            if (indices.containsKey(index)) {
                i = Math.max(i, indices.get(index)); // Update the index for the previous occurrence of a character
            }
            // The difference between the latest position of a duplicate (indices[index]) and that of the previous one (j) will give us the current count
            ans = Math.max(ans, j - i);
            indices.put(index, j);
            j++;
        }
        return ans;
    }
}
