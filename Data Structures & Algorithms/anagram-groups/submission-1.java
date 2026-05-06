class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> lookup = new HashMap<>();
        boolean newGroup;
        String str;
        List<String> group;
        for (int i = 0; i < strs.length; i++) {
            newGroup = true;
            str = strs[i];
            for (String key : lookup.keySet()) {
                if (areAnagrams(str, key)) {
                    lookup.get(key).add(str);
                    newGroup = false;
                    break;
                }
            }
            if (newGroup) {
                group = new ArrayList<>();
                group.add(str);
                lookup.put(str, group);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> value : lookup.values()) {
            result.add(value);
        }
        return result;
    }

    private boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] counters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counters[s1.charAt(i) - 'a']++;
            counters[s2.charAt(i) - 'a']--;
        }
        for (int count : counters) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
