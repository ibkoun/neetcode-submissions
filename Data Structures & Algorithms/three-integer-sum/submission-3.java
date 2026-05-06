class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.merge(n, 1, Integer::sum);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            counter.computeIfPresent(nums[i], (key, value) -> value - 1);
            if (i > 0 && nums[i] == nums[i - 1]) { // Skip duplicates
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                counter.computeIfPresent(nums[j], (key, value) -> value - 1);
                if (j > i + 1 && nums[j] == nums[j - 1]) { // Skip duplicates
                    continue;
                }
                /*
                    After decreasing the counter for nums[i] and nums[j], if the counter for sum2 is 0
                    (sum2 can either be nums[i] or nums[j] or a random number not present in the input) 
                    then it is not possible to construct a triplet.
                */
                int sum1 = nums[i] + nums[j];
                int sum2 = -sum1;
                if (counter.getOrDefault(sum2, 0) > 0) { 
                    ans.add(List.of(nums[i], nums[j], sum2));
                }
            }
            for (int j = i + 1; j < nums.length; j++) {
                counter.computeIfPresent(nums[j], (key, value) -> value + 1);
            }
        }
        return ans;
    }
}
