class Solution {
    public int maxArea(int[] heights) {
        int lm = 0;
        int rm = heights.length -1;

        int mw = 0;
        while(lm < rm) {
            int min = Math.min(heights[lm], heights[rm]);
            mw = Math.max(mw, min*(rm - lm));

            if(heights[lm] < heights[rm]) {
                lm++;
            } else {
                rm--;
            }
        }
        return mw;
    }
}
