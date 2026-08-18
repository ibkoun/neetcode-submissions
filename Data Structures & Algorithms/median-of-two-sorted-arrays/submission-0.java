class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1-indexed
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        // Odd total: Median is the middle element
        // Even total: Median is the average of the two middle elements
        if (total % 2 == 0) {
            int left = getKthElement(nums1, 0, m, nums2, 0, n, (total + 1) >> 1);
            int right = getKthElement(nums1, 0, m, nums2, 0, n, (total + 2) >> 1);
            return (left + right) / 2.0;
        } else {
            return getKthElement(nums1, 0, m, nums2, 0, n, (total + 1) >> 1);
        }
    }

    private int getKthElement(int[] a, int aStart, int aLength, int[] b, int bStart, int bLength, int k) {
        if (aLength > bLength) {
            return getKthElement(b, bStart, bLength, a, aStart, aLength, k);
        }

        if (aLength == 0) {
            return b[bStart + k - 1];
        }

        if (k == 1) {
            return Math.min(a[aStart], b[bStart]);
        }

        int i = Math.min(aLength, k >> 1);
        int j = Math.min(bLength, k >> 1);

        int aMid = a[aStart + i - 1];
        int bMid = b[bStart + j - 1];

        if (aMid > bMid) {
            return getKthElement(a, aStart, aLength, b, bStart + j, bLength - j, k - j); // Drop left half of b
        } else {
            return getKthElement(a, aStart + i, aLength - i, b, bStart, bLength, k - i); // Drop left half of a
        }
    }
}
