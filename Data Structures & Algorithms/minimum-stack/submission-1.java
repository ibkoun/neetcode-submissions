class MinStack {
    private int[] stack;
    private int[] prefix;

    public MinStack() {
        stack = new int[0];
        prefix = new int[0];
    }

    public void push(int val) {
        stack = Arrays.copyOf(stack, stack.length + 1);
        stack[stack.length - 1] = val;
        prefix = Arrays.copyOf(prefix, prefix.length + 1);
        if (prefix.length > 1) {
            prefix[prefix.length - 1] = Math.min(val, prefix[prefix.length - 2]);
        } else {
            prefix[0] = val;
        }
    }

    public void pop() {
        stack = Arrays.copyOf(stack, stack.length - 1);
        prefix = Arrays.copyOf(prefix, prefix.length - 1);
    }

    public int top() {
        return stack[stack.length - 1];
    }

    public int getMin() {
        return prefix[prefix.length - 1];
    }
}
