class Solution {
    public int trap(int[] height) {
        int maxW = 0;
        int[] leftPref = new int[height.length];
        int[] rightPref = new int[height.length];

        int leftM = 0;
        int rightM = 0;
        leftPref[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            leftPref[i] = Math.max(leftPref[i-1], height[i]);

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
