class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int lo = 1;
        int hi = piles[n - 1];
        int k = hi;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            int time = h;
            int i = 0;
            while (i < n && time > 0) {
                time -= (int) Math.ceil((double) piles[i] / mid);
                i++;
            }
            if (i == n && time >= 0) {
                hi = mid - 1; // We can minimize the rate even further
                k = mid;
            } else {
                lo = mid + 1; // We need to increase the rate so Koko can eat all the bananas
            }
        }
        return k;
    }
}
