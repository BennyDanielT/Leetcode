class Solution {
    public int largestRectangleArea(int[] heights) {

        int maxArea = 0, currArea;
        int n = heights.length;
        int[] left = new int[n]; // Array to store left boundaries of each index, where the left boundary is the
                                 // index till which there the bars are >= in height
        int[] right = new int[n]; // Same but right side
        left[0] = -1;
        right[n - 1] = n;
        int prevBoundary;// This index is not included while calculating the width of the histogra. *|* |
                         // | | *|*
        int nextBoundary; // Above comment applies

        // Find Left Boundaries
        for (int i = 1; i < n; i++) {
            prevBoundary = i - 1;
            while (prevBoundary >= 0 && heights[prevBoundary] >= heights[i]) {
                prevBoundary = left[prevBoundary];
            }
            left[i] = prevBoundary;
        }

        // Find Right Boundaries

        for (int i = n - 2; i >= 0; i--) {
            nextBoundary = i + 1;
            while (nextBoundary < n && heights[nextBoundary] >= heights[i]) {
                nextBoundary = right[nextBoundary];
            }
            right[i] = nextBoundary;
        }

        for (int i = 0; i < n; i++) {
            currArea = (right[i] - left[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }
}