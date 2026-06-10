class Solution {
    public int maxArea(int[] heights) {
        int mw = 0;

        int beg = 0;
        int end = heights.length - 1;

        while(beg < end) {
            int min = Math.min(heights[beg], heights[end]);
            mw = Math.max(mw, (end - beg) * min);
            if(heights[beg] < heights[end]) {
                beg++;
            } else {
                end--;
            }
        }
        return mw;
    }
}
