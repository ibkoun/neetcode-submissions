class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // Skip duplicates
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) { // Skip duplicates
                    continue;
                }
                int sum = nums[i] + nums[j];
                int k = binarySearch(j + 1, -sum, nums);
                if (k > -1) { 
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                }
            }
        }
        return ans;
    }

    public int binarySearch(int lo, int target, int[] array) {
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
