class Solution {
    public int maxArea(int[] heights) {
        int maxWater = Integer.MIN_VALUE;

        int left = 0;
        int right = heights.length-1;

        while(left <= right) {
            int min = Math.min(heights[left], heights[right]);
            
            int space = right - left;
            int water = min * space;

            maxWater = Math.max(maxWater, water);

            if(heights[left] < heights[right]) left++;
            else right--;
        }
        return maxWater;
    }
}
