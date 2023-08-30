class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        
        backtrack(result,"",n,n);
        return result;
        
    }
    
    
    private void backtrack(List<String> res,String current,int left,int right) //left and right refer to the remaining left parentheses and right parentheses
    {
        if(left==0 && right==0)
        {
            res.add(current);
            return;
        }
        
        if(left>0)//we have more left parentheses to add
        {
            backtrack(res,current+"(",left-1,right);
        }
        
        if(right>left)//This means that the parentheses are unbalanced and we need to close them, A.K.A we have right parentheses left
        {
            backtrack(res,current+")",left,right-1);
        }
    }
        
}