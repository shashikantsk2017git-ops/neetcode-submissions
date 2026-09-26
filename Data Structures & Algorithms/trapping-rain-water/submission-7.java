class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int maxWater = 0;
        while(left < right) {
            if(height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                maxWater += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                maxWater += rightMax - height[right];
                right--;
            }
        }
        return maxWater;
    }

    public int trap0(int[] height) {
        int maxW = 0;
        int[] leftPref = new int[height.length];
        int[] rightPref = new int[height.length];


        int leftM = 0;
        int rightM = 0;
        for(int i = 0; i < height.length; i++) {
            leftM = Math.max(leftM, height[i]);
            leftPref[i] = leftM;

            rightM = Math.max(rightM, height[height.length-1-i]);
            rightPref[height.length-1-i] = rightM;

        }

        for(int i = 0; i < height.length; i++) {
            int leftMax = leftPref[i];
            int rightMax = rightPref[i];
            maxW += Math.min(leftMax, rightMax) - height[i];
        }
        return maxW;
    }
}
