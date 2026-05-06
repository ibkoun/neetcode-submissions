class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        // Area of water = Area between two larger bars - Area of smaller bars between the two largest bars
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int right = 0; right < n; right++) {
            while (!stack.isEmpty() && height[right] >= height[stack.getLast()]) {
                int mid = stack.removeLast();
                if (!stack.isEmpty()) {
                    int left = stack.getLast();
                    int h = Math.min(height[left], height[right]) - height[mid];
                    int w = right - left - 1;
                    area += h * w;
                }
            }
            stack.add(right);
        }

        return area;
    }
}
