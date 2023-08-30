class Solution {
    public int[] productExceptSelf(int[] nums) {
        
       int[] ans = new int[nums.length];
        
        int prev=1,post=1;
        
        for(int i=0;i<nums.length;i++)
        {
            ans[i]=1;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            ans[i]*=prev;
            prev*=nums[i];
            ans[nums.length-i-1]*=post;
            post*=nums[nums.length-i-1];
        }
        return ans;
    }
}