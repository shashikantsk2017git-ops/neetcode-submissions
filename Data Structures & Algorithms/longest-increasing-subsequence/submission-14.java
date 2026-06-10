class Solution {
    public int lengthOfLIS(int[] nums) {
        // return calLIS(nums, -1, 0);
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        // return calLIS(nums, -1, 0, dp);
        return calLIS(nums);
    }

    public int calLIS(int[] nums, int prev, int ind) {
        if(ind > nums.length-1) {
            return 0;
        }

        int take = -1;
        if(prev == -1 || nums[prev] < nums[ind]) {
            take = 1 + calLIS(nums, ind, ind+1);
        }
        int nottake = calLIS(nums, prev, ind+1);
        return Math.max(take, nottake);
    }

    public int calLIS(int[] nums, int prev, int ind, int[][] dp) {
        if(ind > nums.length-1) {
            return 0;
        }
        if(dp[prev+1][ind] != -1) return dp[prev+1][ind];
        int take = -1;
        if(prev == -1 || nums[prev] < nums[ind]) {
            take = 1 + calLIS(nums, ind, ind+1);
        }
        int nottake = calLIS(nums, prev, ind+1);
        return dp[prev+1][ind] = Math.max(take, nottake);
    }

    public int calLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for(int ind = nums.length-1; ind>=0; ind--) {
            for(int prev = ind-1; prev>=-1; prev--) {
                int take = -1;
                if(prev == -1 || nums[prev] < nums[ind]) {
                    take = 1 + dp[ind+1][ind+1];
                }
                int nottake = dp[prev+1][ind+1];
                dp[prev+1][ind] = Math.max(take, nottake);
            }
        }
        return dp[0][0];
    }
}