class Solution {
    public int maxArea(int[] heights) {
        int mw = 0;

        int beg = 0;
        int end = heights.length - 1;

        while(beg < end) {
            int small = 0;
            int len = end - beg;
            if(heights[beg] < heights[end]) {
                small = beg;
                beg++;
            } else {
                small = end;
                end--;
            }
            
            mw = Math.max(mw, len * heights[small]);
        }
        return mw;
    }
}
