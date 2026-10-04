class Solution {
    public int lengthOfLIS(int[] nums) {
        // return findLIS(nums, -1, 0);
        int[][] dp = new int[nums.length+1][nums.length];
        for(int[] ar: dp) Arrays.fill(ar, -1);
        // return findLIS(nums, -1, 0, dp);
        // return findLIS(nums);
        return findLISOpt(nums);
    }

    private int findLIS(int[] nums, int prev, int ind) {
        if(ind == nums.length) {
            return 0;
        }
        int take = 0;
        if(prev == -1 || nums[prev] < nums[ind]) {
            take = 1 + findLIS(nums, ind, ind+1);
        }
        int nottake = findLIS(nums, prev, ind+1);
        return Math.max(take, nottake);
    }

    private int findLIS(int[] nums, int prev, int ind, int[][] dp) {
        if(ind == nums.length) {
            return 0;
        }
        if(dp[prev+1][ind] != -1) return dp[prev+1][ind];
        int take = 0;
        if(prev == -1 || nums[prev] < nums[ind]) {
            take = 1 + findLIS(nums, ind, ind+1, dp);
        }
        int nottake = findLIS(nums, prev, ind+1, dp);
        return dp[prev+1][ind] = Math.max(take, nottake);
    }

    private int findLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];

        for(int ind = nums.length - 1; ind >=0; ind--) {
            for(int prev = nums.length - 1; prev >=-1; prev--) {
                int take = 0;
                if(prev == -1 || nums[prev] < nums[ind]) {
                    take = 1 + dp[ind+1][ind+1];
                }
                int nottake = dp[prev+1][ind+1];
                dp[prev+1][ind] = Math.max(take, nottake);
            }
        }
        return dp[0][0];
    }

    private int findLISOpt(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];

        for(int ind = nums.length - 1; ind >=0; ind--) {
            for(int prev = nums.length - 1; prev >=-1; prev--) {
                int take = 0;
                if(prev == -1 || nums[prev] < nums[ind]) {
                    take = 1 + dp[ind+1][ind+1];
                }
                int nottake = dp[prev+1][ind+1];
                dp[prev+1][ind] = Math.max(take, nottake);
            }
        }
        return dp[0][0];
    }

    private int findLISOpt1(int[] nums) {
        int[] curr = new int[nums.length+1];
        int[] prv = new int[nums.length+1];

        for(int ind = nums.length - 1; ind >=0; ind--) {
            for(int prev = nums.length - 1; prev >=-1; prev--) {
                int take = 0;
                if(prev == -1 || nums[prev] < nums[ind]) {
                    take = 1 + curr[ind+1];
                }
                int nottake = curr[ind+1];
                curr[ind] = Math.max(take, nottake);
            }
            prv = curr;
        }
        return prv[0];
    }
}
