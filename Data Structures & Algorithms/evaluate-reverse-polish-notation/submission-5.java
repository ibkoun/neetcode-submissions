class Solution {
    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (stack.size() >= 2 && isOperator(token)) {
                int b = stack.removeLast();
                int a = stack.removeLast();
                stack.add(eval(a, b, token));
            }
            if (!isOperator(token)) {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.isEmpty() ? 0 : stack.getLast();
    }

    private boolean isOperator(String op) {
        return op.equals(ADDITION) || op.equals(SUBTRACTION) || op.equals(MULTIPLICATION) || op.equals(DIVISION);
    }

    private int eval(int a, int b, String op) {
        switch(op) {
            case ADDITION -> {
                return a + b;
            }
            case SUBTRACTION -> {
                return a - b;
            }
            case MULTIPLICATION -> {
                return a * b;
            }
            case DIVISION -> {
                return a / b;
            }
            default -> {
                return 0;
            }
        }
    }
}
