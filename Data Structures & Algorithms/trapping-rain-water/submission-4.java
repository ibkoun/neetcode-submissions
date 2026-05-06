class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int area = 0;
        int l = 0;
        int r = n - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        while (l < r) {
            // Each increment adds an area of width equal to 1
            if (height[l] <= height[r]) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                area += leftMax - height[l]; // Calculate the area above height[l]
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                area += rightMax - height[r]; // Calculate the area above height[r]
            }
        }

        return area;
    }
}
