class Solution {
    public boolean isValid(String s) {
        
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        
        for(char ch:arr)
        {
            if(map.values().contains(ch))
                stack.push(ch);
            else if(map.keySet().contains(ch))
                    {
                        if(!stack.isEmpty() && stack.peek()==map.get(ch))
                        {
                            stack.pop();
                        }
                        else
                            return false;
                    }
        }
        return stack.isEmpty();
    }
}