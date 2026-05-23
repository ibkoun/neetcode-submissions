class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] > nums[n - 1]) { // The smallest element should be in the right half
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return nums[lo];
    }
}
