class Solution {
    public int trap(int[] height) {
        int maxW = 0;
        int[] leftPref = new int[height.length];
        int[] rightPref = new int[height.length];

        int leftM = 0;
        int rightM = 0;
        for(int i = 0; i < height.length; i++) {
            leftM = Math.max(leftM, height[i]);
            leftPref[i] = leftM;

        }
        for(int i = height.length-1; i >=0; i--) {
            rightM = Math.max(rightM, height[i]);
            rightPref[i] = rightM;
        }

        for(int i = 0; i < height.length; i++) {
            int leftMax = leftPref[i];
            int rightMax = rightPref[i];
            maxW += Math.min(leftMax, rightMax) - height[i];
        }
        return maxW;
    }
}
