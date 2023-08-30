class Solution {
    public boolean isPalindrome(String s) {
        
        String str = s.toLowerCase();
        int start = 0,finish=s.length()-1;
        char beg,end;
        while(start<=finish)
        {
            beg=str.charAt(start);
            end=str.charAt(finish);
            if(!Character.isLetterOrDigit(beg))
            {
                start++;
            }
            
            else if(!Character.isLetterOrDigit(end))
            {
                finish--;
            }
            
            else
            {
                if(beg!=end)
                {
                return false;
                }
                start++;
                finish--;
            }
           
        }
        return true;
}
}