class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int one = robbing(0, nums.length-2, nums, new int[n][n]);
        int last = robbing(1, nums.length-1, nums, new int[n][n]);
        return Math.max(one, last);
    }

    public int robbing(int first, int last, int[] nums, int[][] dp) {
        if(first > last) {
            return 0;
        }
        if(dp[first][last] != 0) return dp[first][last];
        int take = nums[first] + robbing(first+2, last, nums, dp);
        int notTake= robbing(first+1, last, nums, dp);

        return dp[first][last] = Math.max(take, notTake);
    }
}
