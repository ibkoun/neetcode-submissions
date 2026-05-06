class Solution {
    public int maxArea(int[] heights) {
        if (heights.length < 2) {
            return 0;
        }
        
        int l = 0;
        int r = heights.length - 1;
        int a = 0;
        while (l < r) {
            int h = Math.min(heights[l], heights[r]);
            int w = Math.abs(l - r);
            a = Math.max(a, h * w);
            // We might find a bar with greater heights while maximizing the width
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return a;
    }
}
