class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int hi = numbers.length - 1;
        for (int i = 0; i < numbers.length - 1; i++) {
            int lo = i + 1;
            while (lo <= hi) {
                int mid = (lo + hi) >> 1;
                if (numbers[mid] + numbers[i] == target) {
                    return new int[] {Math.min(i, mid) + 1, Math.max(i, mid) + 1};
                } else if (numbers[mid] + numbers[i] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return new int[0];
    }
}
