class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Flattened index = row index * matrix[0].length + column index
        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = Arrays.stream(matrix).flatMapToInt(Arrays::stream).toArray();
        int lo = 0;
        int hi = m * n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
