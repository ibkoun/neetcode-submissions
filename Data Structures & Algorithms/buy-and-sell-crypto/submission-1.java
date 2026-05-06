class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 0;
        int j = 1;
        while (i < j && j < prices.length) {
            if (prices[j] > prices[i]) {
                profit = Math.max(profit, prices[j] - prices[i]);
                j++;
            } else {
                j = ++i + 1;
            }
        }
        return profit;
    }
}
