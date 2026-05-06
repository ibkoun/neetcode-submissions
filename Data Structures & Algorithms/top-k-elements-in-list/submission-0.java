class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            lookup.putIfAbsent(nums[i], 0);
            lookup.computeIfPresent(nums[i], (key, value) -> value + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (i, j) -> lookup.get(j) - lookup.get(i));
        for (Integer num : lookup.keySet()) {
            heap.add(num);
        }

        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = heap.poll();
        }
        return output;
    }
}
