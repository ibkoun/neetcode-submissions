class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(i -> -position[i]));

        Deque<Double> stack = new ArrayDeque<>();
        int index = indices[0];
        double time = (double) (target - position[index]) / speed[index];
        stack.add(time);
        for (int i = 1; i < n; i++) {
            // Calculate the time required for the current car and the one preceding it to reach the target position
            index = indices[i];
            time = (double) (target - position[index]) / speed[index];
            if (!stack.isEmpty() && time > stack.getLast()) {
                // If the car behind is slower, then it will form a separate fleet; therefore, we add it to the stack
                stack.add(time);
            }
        }

        return stack.size(); // Each element in the stack represents a fleet
    }
}
