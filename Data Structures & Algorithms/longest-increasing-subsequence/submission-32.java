class Solution {
    public int lengthOfLIS(int[] nums) {
        // return findLIS(nums, -1, 0);
        int[][] dp = new int[nums.length+1][nums.length];
        for(int[] ar: dp) Arrays.fill(ar, -1);
        return findLIS(nums, -1, 0, dp);
    }

    private int findLIS(int[] nums, int prev, int ind) {
        if(ind == nums.length) {
            return 0;
        }
        int first = 0;
        if(prev == -1 || nums[prev] < nums[ind]) {
            first = 1 + findLIS(nums, ind, ind+1);
        }
        int second = findLIS(nums, prev, ind+1);
        return Math.max(first, second);
    }

    private int findLIS(int[] nums, int prev, int ind, int[][] dp) {
        if(ind == nums.length) {
            return 0;
        }
        if(dp[prev+1][ind] != -1) return dp[prev+1][ind];
        int first = 0;
        if(prev == -1 || nums[prev] < nums[ind]) {
            first = 1 + findLIS(nums, ind, ind+1, dp);
        }
        int second = findLIS(nums, prev, ind+1, dp);
        return dp[prev+1][ind] = Math.max(first, second);
    }
}
