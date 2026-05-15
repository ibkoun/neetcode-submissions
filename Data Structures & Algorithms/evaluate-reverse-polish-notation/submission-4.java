class Solution {
    private static final String DIGITS = "[0-9]+|-[0-9]+";
    private static final String OPERATORS = "[\\+\\-\\*\\/]";

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (stack.size() >= 2 && token.matches(OPERATORS)) {
                int b = stack.removeLast();
                int a = stack.removeLast();
                stack.add(eval(a, b, token));
            }
            if (token.matches(DIGITS)) {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.isEmpty() ? 0 : stack.getLast();
    }

    private int eval(int a, int b, String op) {
        switch(op) {
            case "+" -> {
                return a + b;
            }
            case "-" -> {
                return a - b;
            }
            case "*" -> {
                return a * b;
            }
            case "/" -> {
                return a / b;
            }
            default -> {
                return 0;
            }
        }
    }
}
