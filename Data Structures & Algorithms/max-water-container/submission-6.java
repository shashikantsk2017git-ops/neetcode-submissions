class Solution {
    public int maxArea(int[] heights) {
        int maxW = 0;
        int left = 0;
        int right = heights.length - 1;

        while(left < right) {
            int diff = right - left;
            int min = 0;
            if(heights[left] < heights[right]) {
                min = heights[left];
                left++;
            } else {
                min = heights[right];
                right--;
            }
            int contains = min * diff;
            maxW = Math.max(maxW, contains);
        }
        return maxW;
    }
}
