class Solution {
    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
        int i = 0; // Pointer of the stack
        int size = 1; // Size of the stack
        for (int j = 1; j < s.length(); j++) {
            char current = s.charAt(j);
            if (i > -1 && closeable(s.charAt(i), current)) {
                i--;
                size--;
                continue;
            }
            if (current == '(' || current == '{' || current == '[') {
                i = j;
                size++;
            } else {
                return false;
            }
        }
        return size == 0;
    }

    private boolean closeable(char p1, char p2) {
        return (p1 == '(' && p2 == ')') || (p1 == '{' && p2 == '}') || (p1 == '[' && p2 == ']');
    }
}
