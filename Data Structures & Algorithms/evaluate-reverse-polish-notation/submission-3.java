class Solution {
    private static final String DIGITS = "[0-9]+|-[0-9]+";
    private static final String OPERATORS = "[\\+\\-\\*\\/]";

    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (stack.size() >= 2 && token.matches(OPERATORS)) {
                String b = stack.removeLast();
                String a = stack.removeLast();
                stack.add(Integer.toString(eval(a, b, token)));
            }
            if (token.matches(DIGITS)) {
                stack.add(token);
            }
        }
        return stack.isEmpty() ? 0 : Integer.parseInt(stack.getLast());
    }

    private int eval(String x, String y, String op) {
        if (!x.matches(DIGITS) || !y.matches(DIGITS) || !op.matches(OPERATORS)) {
            return 0;
        }
        int a = Integer.parseInt(x);
        int b = Integer.parseInt(y);
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
