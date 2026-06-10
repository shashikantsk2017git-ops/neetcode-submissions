class Solution {
    public int rob(int[] nums) {
        // return robbing(nums, 0);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return robbing(nums, 0, dp);
    }

    public int robbing(int[] nums, int ind) {
        if (ind >= nums.length)
            return 0;
        // take
        int take = nums[ind] + robbing(nums, ind + 2);
        // not take
        int nottake = robbing(nums, ind + 1);

        return Math.max(take, nottake);
    }

    public int robbing(int[] nums, int ind, int[] dp) {
        if (ind >= nums.length)
            return 0;
        if (dp[ind] != -1)
            return dp[ind];
        // take
        int take = nums[ind] + robbing(nums, ind + 2, dp);
        // not take
        int nottake = robbing(nums, ind + 1, dp);

        return dp[ind] = Math.max(take, nottake);
    }
}
