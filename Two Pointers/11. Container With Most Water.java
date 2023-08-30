class Solution {
    public int maxArea(int[] height) {
        
        int maxArea=0,currentArea=0;
        int tempI,tempJ;
        int i=0,j=height.length-1;
        while(i<j)
        {
            currentArea=Math.min(height[i],height[j])*(j-i);
            maxArea=Math.max(currentArea,maxArea);
            if(height[i]<height[j])
            {
                tempI=height[i];
                while(i<j && height[i]<=tempI)
                    i++;
            }
            else
            {
                tempJ=height[j];
                while(i<j && height[j]<=tempJ)
                    j--;
            }
        }
        return maxArea;
        
    }
}