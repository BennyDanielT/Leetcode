class Solution {
    public int trap(int[] height) {
        
        int l=0,r=height.length-1;
        
        int leftMax=height[l],rightMax=height[r];
        int water=0;
        
        while(l<r)
        {
            if(leftMax<=rightMax)
            {
                l++;
                // bottleneck=Math.min()              
                leftMax=Math.max(leftMax,height[l]);
                water+=leftMax-height[l];
            }
            else
            {
                r--;
                rightMax=Math.max(rightMax,height[r]);
                water+=rightMax-height[r];
            }
        }
       return water; 
    }
}