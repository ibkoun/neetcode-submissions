class MinStack {
    private final Deque<Integer> stack;
    private final Deque<Integer> prefix;

    public MinStack() {
        stack = new ArrayDeque<>();
        prefix = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.add(val);
        if (prefix.isEmpty()) {
            prefix.add(val);
        } else {
            prefix.add(Math.min(val, prefix.getLast()));
        }
        
    }

    public void pop() {
        stack.removeLast();
        prefix.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return prefix.getLast();
    }
}
