class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res;
        for (String s : tokens) {
            if ("+-/*".contains(s)) {

                res = stack.push(calculate(stack.pop(), stack.pop(), s));
                System.out.println(res);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();

    }

    private int calculate(int a, int b, String s) {
        if (s.equals("+"))
            return a + b;
        else if (s.equals("-"))
            return b - a;
        else if (s.equals("*"))
            return a * b;
        else
            return b / a;

    }
}