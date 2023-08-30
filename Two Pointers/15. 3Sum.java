class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> temp;
        int currSum;
        
        Arrays.sort(nums);
        int j,k;
        for(int i=0;i<nums.length-1;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            j=i+1;
            k=nums.length-1;
            while(j<k)
            {
                currSum=nums[i]+nums[j]+nums[k];
                if(currSum<0)
                {
                    j++;
                }
                
                else if(currSum>0)
                {
                    k--;
                }
                else
                {
                    temp=Arrays.asList(nums[i],nums[j],nums[k]);
                    result.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++; 
                    while (j < k && nums[k] == nums[k + 1]) k--;  
                }
              
            }
            
        }
        
        
       return result; 
        
    }
}