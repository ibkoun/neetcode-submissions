class Solution {
    public int search(int[] nums, int target) {
        // Find the index of the smallest element (or largest depending on the implementation)
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        // Search the left half
        int ans = binarySearch(0, lo - 1, target, nums);
        if (ans > -1) {
            return ans;
        }

        // Search right half
        return binarySearch(lo, n - 1, target, nums);
    }

    private int binarySearch(int lo, int hi, int target, int[] nums) {
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
