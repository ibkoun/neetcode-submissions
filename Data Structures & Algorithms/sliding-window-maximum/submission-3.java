class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Store the indices i in decreasing order of nums[i]
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparing(i -> -nums[i]));
        for (int i = 0; i < k; i++) {
            queue.add(i);
        }

        if (queue.isEmpty()) {
            return new int[0];
        }

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        ans[0] = nums[queue.peek()];
        int p = 1; // Pointer for ans
        for (int r = k; r < n; r++) { // Right edge of the window
            int l = r - k + 1; // Left edge of the window
            queue.add(r);
            while (!queue.isEmpty() && queue.peek() < l) { // Check if the maximum element is still within the window
                queue.poll(); // Remove the top largest elements that are outside the window
            }
            if (!queue.isEmpty()) {
                ans[p++] = nums[queue.peek()];
            }
        }

        return ans;
    }
}
