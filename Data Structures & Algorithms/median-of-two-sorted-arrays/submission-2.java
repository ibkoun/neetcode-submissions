class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int half = (total + 1) >> 1;
        
        int[] a = nums1;
        int[] b = nums2;
        
        if (a.length > b.length) {
            a = nums2;
            b = nums1;
        }

        int lo = 0;
        int hi = a.length;
        while (lo <= hi) {
            int i = (lo + hi) >> 1; // Number of elements of A included in the left half
            int j = half - i; // Number of elements of B included in the left half

            int aLeft = i > 0 ? a[i - 1] : Integer.MIN_VALUE;
            int aRight = i < a.length ? a[i] : Integer.MAX_VALUE;
            int bLeft = j > 0 ? b[j - 1] : Integer.MIN_VALUE;
            int bRight = j < b.length ? b[j] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                if (total % 2 == 0) {
                    int left = Math.max(aLeft, bLeft);
                    int right = Math.min(aRight, bRight);
                    return (left + right) / 2.0;
                } else {
                    return Math.max(aLeft, bLeft);
                }
            } else if (aLeft > bRight) {
                hi = i - 1; // Too many elements from A included in the left half, so we move the cut point to the left
            } else if (bLeft > aRight) {
                lo = i + 1; // Too few elements from A excluded from the left half, so we move the cut point to the right
            }
        }

        return -1;
    }
}
