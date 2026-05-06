class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[] {0, 1};
        }

        Map<Integer, List<Integer>> lookup = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (lookup.containsKey(nums[i])) {
                lookup.get(nums[i]).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                lookup.put(nums[i], indices);
            }
        }

        int[] indices = new int[] {-1, -1};
        int complement;
        int j;
        int k;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if (lookup.containsKey(complement)) {
                k = 0;
                do {
                    j = lookup.get(complement).get(k);
                    k++;
                }  while (k < lookup.get(complement).size() && i == j);
                if (i < j) {
                    indices[0] = i;
                    indices[1] = j;
                    break;
                } else if (i > j) {
                    indices[0] = j;
                    indices[1] = i;
                    break;
                }
            }
        }

        return indices;
    }
}
