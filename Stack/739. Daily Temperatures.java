class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] wait = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        int index;
        for(int i=0;i<temperatures.length;i++)
        {
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
            {
                index=stack.pop();
                temperatures[index]=i-index;
            }
            stack.push(i);
        }
        
        return wait;
    }
}