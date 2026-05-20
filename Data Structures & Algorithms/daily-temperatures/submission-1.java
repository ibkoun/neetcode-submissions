class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int i = 0;
        for (int j = 1; j < n; j++) {
            while (i >= 0 && temperatures[j] > temperatures[i]) {
                if (ans[i] == 0) {
                    ans[i] = j - i;
                }
                i--;
            }
            i = j;
        }
        return ans;
    }
}
