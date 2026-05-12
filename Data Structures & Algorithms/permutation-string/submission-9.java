class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char a = 'a';
        int n = 26;
        Map<Integer, Integer> counter1 = new HashMap<>(); // Store the number of occurrences of each character in s1
        Map<Integer, Integer> indices2 = new HashMap<>(); // Store the index of the earliest occurrence of a character in s2 that is also present in s1
        for (int i = 0; i < s1.length(); i++) {
            int c = s1.charAt(i) - a;
            counter1.merge(c, 1, Integer::sum);
            indices2.putIfAbsent(c, -1);
        }

        int[] counter2 = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            int current = s2.charAt(i) - a;

            // Reset if the current character in s2 is not found in s1
            if (!counter1.containsKey(current)) {
                int end = sb.length() - 1;
                for (int j = end; j >= 0; j--) {
                    int c = sb.charAt(j) - a;
                    indices2.put(c, -1);
                    counter2[c] = 0;
                    sb.deleteCharAt(j);
                }
                continue;
            }

            sb.append(s2.charAt(i));
            
            if (++counter2[current] <= counter1.get(current)) {
                boolean match = true;
                for (Integer c : counter1.keySet()) {
                    if (counter2[c] != counter1.get(c)) {
                        match = false;
                        break;
                    }
                }
                if (sb.length() == s1.length() && match) {
                    return true;
                }
                if (indices2.get(current) < 0) {
                    indices2.put(current, i);
                }
            } else {
                for (int j = sb.length() - 1 - (i - indices2.get(current)); j >= 0; j--) {
                    int previous = s2.charAt(j) - a;
                    counter2[previous]--;
                    sb.deleteCharAt(j);
                }
                for (int j = indices2.get(current) + 1; j <= i; j++) {
                    int previous = s2.charAt(j) - a;
                    if (previous == current) {
                        indices2.put(current, j);
                        break;
                    }
                }
            }
        }

        return false;
    }
}
