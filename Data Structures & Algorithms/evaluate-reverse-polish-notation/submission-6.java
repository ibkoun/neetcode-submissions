class Solution {
    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals(ADDITION) || token.equals(SUBTRACTION) || token.equals(MULTIPLICATION) || token.equals(DIVISION)) {
                int b = stack.removeLast();
                int a = stack.removeLast();
                stack.add(eval(a, b, token));
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.getLast();
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
