class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> lookup = new HashMap<>();
        char[] chars;
        String pattern;
        for (String str : strs) {
            chars = str.toCharArray();
            Arrays.sort(chars);
            pattern = new String(chars);
            lookup.putIfAbsent(new String(chars), new ArrayList<>());
            lookup.get(pattern).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> value : lookup.values()) {
            result.add(value);
        }
        return result;
    }
}
