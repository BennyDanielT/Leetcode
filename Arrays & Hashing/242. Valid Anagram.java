class Solution {
    public boolean isAnagram(String s, String t) {
                
        if(s.length()!=t.length())
        {
            return false;

        }
        
        int[] sarr = new int[26];
        int[] tarr = new int[26];
       
        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();
        
        for(int i=0;i<s.length();i++)
        {
            sarr[sarray[i]-'a']++;
            tarr[tarray[i]-'a']++;
        }
        
        for(int i=0;i<sarr.length;i++)
        {
            if(sarr[i]!=tarr[i])
            {
                return false;
            }
        }
        
        return true;
    }
}