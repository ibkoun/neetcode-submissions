class Solution {
    public int longestConsecutive(int[] nums) {
        DSU dsu = new DSU(nums);
        return dsu.solve();
    }
}

class DSU {
    private final Map<Integer, Integer> parents;
    private final Map<Integer, Integer> size;
    private int maxSize;

    public DSU(int[] nums) {
        maxSize = 1;
        parents = new HashMap<>();
        size = new HashMap<>();
        for (int n : nums) {
            parents.put(n, n);
            size.put(n, 1);
        }
    }

    public int solve() {
        if (parents.isEmpty()) {
            return 0;
        }
        for (int n : parents.keySet()) {
            if (parents.containsKey(n + 1)) {
                union(n, n + 1);
            }
        }
        return maxSize;
    }

    public int find(int i) {
        if (parents.get(i) == i) {
            return i;
        }
        return find(parents.get(i));
    }

    public void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi != pj) {
            // Ensure that the root contains the size of the set. The root is not necessarily the smallest number of the sequence.
            if (size.get(pi) >= size.get(pj)) {
                parents.put(pj, pi);
                size.computeIfPresent(pi, (key, value) -> value + size.get(pj));
                maxSize = Math.max(maxSize, size.get(pi));
            } else if (size.get(pj) > size.get(pi)) {
                parents.put(pi, pj);
                size.computeIfPresent(pj, (key, value) -> value + size.get(pi));
                maxSize = Math.max(maxSize, size.get(pj));
            }
        }
    }
}
