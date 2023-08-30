class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> logger = new HashMap<>(); //HashMap of Value and Index of each value
        int answer[]=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            
            if(logger.containsKey(target-nums[i]))
            {
                answer[0]=i;
                answer[1]=logger.get(target-nums[i]);

            }
            logger.putIfAbsent(nums[i],i);
        }
       return answer; 
    }
}