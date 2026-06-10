class Solution {
    public int rob(int[] nums) {
        int n = nums.length-1;
        // int first = robbing(nums, 0, n-1);
        // int last = robbing(nums, 1, n);
        if(n == 0) return nums[0];
        int first = robbing(nums, 0, n-1, new int[n+1]);
        int last = robbing(nums, 1, n, new int[n+1]);

        return Math.max(first, last);
    }

    public int robbing(int[] nums, int start, int end) {

        if(start > end) {
            return 0;
        }
        //take
        int take = nums[start] + robbing(nums, start+2, end);

        //not take
        int nottake = robbing(nums, start+1, end);

        return Math.max(take, nottake);
    }

    public int robbing(int[] nums, int start, int end, int[] dp) {

        if(start > end) {
            return 0;
        }

        if(dp[start] != 0) return dp[start];
        //take
        int take = nums[start] + robbing(nums, start+2, end, dp);

        //not take
        int nottake = robbing(nums, start+1, end, dp);

        return dp[start] = Math.max(take, nottake);
    }
}
