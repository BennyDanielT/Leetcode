class MinStack {
    int min;
    Stack<Integer> stack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<Integer>();
    }

    public void push(int val) {
        // Push the current min in the stack (Note that this is a duplicuate instance of
        // the element since we would have already pushed it in the stack) so that when
        // we pop the stack in the future we would know what the new min is.
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.pop() == min)
            min = stack.pop();// Here's where we are removing the duplicate instance of the 2nd min and
                              // assigning it to the min variable

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */