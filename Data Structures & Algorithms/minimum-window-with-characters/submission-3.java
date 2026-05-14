class Solution {
    public String minWindow(String s, String t) {
        String emptyString = "";

        if (s.length() == 1 && t.length() == 1) {
            return Objects.equals(s, t) ? t : emptyString;
        }
        if (s.length() < t.length()) {
            return emptyString;
        }

        Map<Character, Integer> tFreq = new HashMap<>(); // Frequency of each character of t
        for (int i = 0; i < t.length(); i++) {
            tFreq.merge(t.charAt(i), 1, Integer::sum);
        }

        Map<Character, Integer> sFreq = new HashMap<>(); // Frequency of each character of s
        Map<Character, Integer> sRemaining = new HashMap<>(); // Track the remaining occurrences of each character of s
        Deque<Integer> indices = new ArrayDeque<>(); // Indices of characters of s that are also present in t
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tFreq.containsKey(c)) {
                sFreq.putIfAbsent(c, 0);
                sRemaining.merge(c, 1, Integer::sum);
                indices.add(i);
            }
        }

        // Check if s contains each character of t or if s has sufficient copies of each character
        for (Map.Entry<Character, Integer> entry : tFreq.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (!sRemaining.containsKey(c) || sRemaining.get(c) < count) {
                return emptyString;
            }
        }

        String substring = emptyString;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.isEmpty()) {
                // The first character of the substring must be one of the characters of t
                if (!tFreq.containsKey(c)) {
                    continue;
                }
                indices.pollFirst();
            }

            sb.append(c);

            if (tFreq.containsKey(c)) {
                if (sRemaining.get(c) + sFreq.get(c) >= tFreq.get(c)) {
                    sRemaining.merge(c, -1, Integer::sum);
                    sFreq.merge(c, 1, Integer::sum);
                    while (valid(sFreq, tFreq)) {
                        if ((sb.length() < substring.length() || substring.isEmpty())) {
                            substring = sb.toString();
                        }
                        if (indices.isEmpty()) {
                            break;
                        }
                        int cutoff = indices.removeFirst() - 1 - (i + 1 - sb.length()); // Shrink the window from the left side until we reach the next valid character
                        for (int j = cutoff; j >= 0; j--) {
                            sFreq.computeIfPresent(sb.charAt(j), (key, value) -> value - 1);
                            sb.deleteCharAt(j);
                        }
                    }
                } else {
                    return emptyString; // Early stop if we cannot meet the required frequency of a character of t
                }
            }
        }

        return substring;
    }

    // Check if every character in t is present in s
    private boolean valid(Map<Character, Integer> sFreq, Map<Character, Integer> tFreq) {
        for (Map.Entry<Character, Integer> entry : tFreq.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (sFreq.get(c) < count) {
                return false;
            }
        }
        return true;
    }
}
