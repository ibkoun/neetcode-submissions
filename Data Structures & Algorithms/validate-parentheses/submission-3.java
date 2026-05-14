class Solution {
    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!stack.isEmpty() && closeable(stack.getLast(), current)) {
                stack.removeLast();
                continue;
            }
            if (current == '(' || current == '{' || current == '[') {
                stack.add(current);
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean closeable(char p1, char p2) {
        return (p1 == '(' && p2 == ')') || (p1 == '{' && p2 == '}') || (p1 == '[' && p2 == ']');
    }
}
