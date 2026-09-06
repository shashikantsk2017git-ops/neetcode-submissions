class Solution {
    public int lengthOfLIS(int[] nums) {
        // return findLIS(nums, -1, 0);
        int[][] dp = new int[nums.length+1][nums.length];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        // return findLIS(nums, -1, 0, dp);
        return findLIS(nums);
    }

    private int findLIS(int[] nums, int prev, int curr) {

        if(curr == nums.length) return 0;
        //take
        int take = 0;
        if(prev == -1 || nums[prev] < nums[curr]) {
            take = 1 + findLIS(nums, curr, curr+1);
        }
        //Not take
        int nottake = findLIS(nums, prev, curr+1);
        return Math.max(take, nottake);
    }

    private int findLIS(int[] nums, int prev, int curr, int[][] dp) {

        if(dp[prev+1][curr] != -1) return dp[prev+1][curr];
        if(curr == nums.length) return 0;
        //take
        int take = 0;
        if(prev == -1 || nums[prev] < nums[curr]) {
            take = 1 + findLIS(nums, curr, curr+1);
        }
        //Not take
        int nottake = findLIS(nums, prev, curr+1);
        return dp[prev+1][curr] = Math.max(take, nottake);
    }

    private int findLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];

        for(int curr = nums.length-1; curr >=0; curr--) {
            for(int prev = nums.length-1; prev >=-1; prev--) {
                //take
                int take = 0;
                if(prev == -1 || nums[prev] < nums[curr]) {
                    take = 1 + dp[curr+1][curr+1];
                }
                //Not take
                int nottake = dp[prev+1][curr+1];
                
                dp[prev+1][curr] = Math.max(take, nottake);
            }
        }
        return dp[0][0];
    }
}