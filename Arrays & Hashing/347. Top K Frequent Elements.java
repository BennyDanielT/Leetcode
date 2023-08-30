class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        int[] result = new int[k];
        
        for(int i:nums)
        {
            map.computeIfPresent(i,(key,val) -> val +1);
            map.putIfAbsent(i,1);
        }
        
        Queue<Integer> queue = new PriorityQueue<>((n1,n2)->map.get(n1)-map.get(n2));
        for(int i:map.keySet())
        {
            queue.add(i);
            if(queue.size()>k)
            {
                queue.poll();
            }
        }
        
        for(int i=0;i<k;i++)
        {
            result[i]=queue.poll();
        }
        
        return result;
        
    }
}

/*
 * ## Special Learnings
	Priority Queue and its operations [add / offer / remove / poll]
-> Priority Queue Lambda Function as Comparator =>**((n1,n2)->map.get(n1)-map.get(n2))**,
here if n1 > n2, n2 will be on top of the queue and will get dequeued first. 

```
❌ I initially thought that n1 will be on top of the queue and will get dequeued first which is wrong.
```
 
 */