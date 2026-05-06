class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            lookup.putIfAbsent(nums[i], 0);
            lookup.computeIfPresent(nums[i], (key, value) -> value + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(num -> -lookup.get(num)).thenComparingInt(num -> (int) num));
        for (Map.Entry<Integer, Integer> entry: lookup.entrySet()) {
            heap.add(entry.getKey());
        }

        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = heap.poll();
        }
        return output;
    }
}