class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return -1;
        }

        // Each number in the array represent the next node
        int slow = 0;
        int fast = 0;
        while (slow < n && fast < n) {
            slow = nums[slow]; // 1 step
            fast = nums[nums[fast]]; // 2 steps
            if (slow == fast) {
                int index = 0;
                while (slow < n && index < n) {
                    if (slow == index) {
                        return index;
                    }
                    slow = nums[slow];
                    index = nums[index];
                }
            }
        }

        return -1;
    }
}
