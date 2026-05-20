class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            while (!stack.isEmpty() && temperatures[j] > temperatures[stack.getLast()]) {
                int i = stack.removeLast();
                ans[i] = j - i;
            }
            stack.add(j);
        }
        return ans;
    }
}
