class TimeMap {
    private final Map<String, List<AbstractMap.SimpleEntry<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // Store a list of pairs of timestamp and value for each key
        map.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new AbstractMap.SimpleEntry<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        
        // Find the upper bound
        List<AbstractMap.SimpleEntry<Integer, String>> list = map.get(key);
        int lo = 0;
        int hi = list.size() - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (list.get(mid).getKey() <= timestamp) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi >= 0 && list.get(hi).getKey() <= timestamp ? list.get(hi).getValue() : "";
    }
}
