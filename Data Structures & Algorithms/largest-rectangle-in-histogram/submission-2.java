class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        int ans = 0;
        for (int r = 0; r < n; r++) {
            // Upper/right bound: current index
            // Lower/left bound: element below the top of the stack
            while (!stack.isEmpty() && heights[r] < heights[stack.getLast()]) {
                int top = stack.removeLast();
                int height = heights[top];
                int width = !stack.isEmpty() ? r - stack.getLast() - 1 : r;
                int area = height * width;
                ans = Math.max(ans, area);
            }
            stack.add(r);
        }

        // Stack is not empty if all the unprocessed elements in the stack are in non-decreasing order
        while (!stack.isEmpty()) {
            int top = stack.removeLast();
            int height = heights[top];
            int width = !stack.isEmpty() ? n - stack.getLast() - 1 : n;
            int area = height * width;
            ans = Math.max(ans, area);
        }

        return ans;
    }
}
