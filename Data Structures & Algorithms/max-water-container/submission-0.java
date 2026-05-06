class Solution {
    public int maxArea(int[] heights) {
        if (heights.length < 2) {
            return 0;
        }
        int a = 0;
        for (int l = 0; l < heights.length - 1; l++) {
            for (int r = heights.length - 1; r > l; r--) {
                int h = Math.min(heights[l], heights[r]);
                int w = Math.abs(l - r);
                a = Math.max(a, h * w);
            }
        }
        return a;
    }
}
