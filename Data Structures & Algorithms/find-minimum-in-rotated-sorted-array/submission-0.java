class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] > nums[hi]) { // The smallest element should be in the right half
                lo = mid + 1;
            } else {
                hi = mid; // The smallest element might be nums[mid]
            }
        }
        return nums[lo];
    }
}
