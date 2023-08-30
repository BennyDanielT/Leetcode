class Solution {
    public int longestConsecutive(int[] nums) {

        int result = 0;
        int maxLength, startNode;
        Set set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        for (int i : nums) {
            if (set.contains(i - 1)) {
                continue;
            }

            startNode = i;
            maxLength = 1;
            while (set.contains(++startNode)) {
                set.remove(startNode);
                maxLength++;
            }

            result = Math.max(result, maxLength);

        }

        return result;
    }
}

/*
 * ## Special Learnings
 * 
 * ✅ Removing elements from a Set helps in reducing Time Complexity while
 * Traversing through the Set again.
 * 
 * #### ✅ There is an alternate solution which involves what I have termed as
 * "Reducing the Search Space" by
 * searching duplicates only in each cell's respective 3X3 block instead of the
 * whole block.
 * 
 */