class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // int first = robbing(nums, 0, n-2);
        // int last = robbing(nums, 1, n-1);
        if(n == 1) return nums[0];
        // int first = robbing(nums, 0, n-1, new int[n+2]);
        // int last = robbing(nums, 1, n, new int[n+2]);

        int first = robbingLoop(nums, 0, n-2);
        int last = robbingLoop(nums, 1, n-1);
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

    public int robbingLoop(int[] nums, int start, int end) {
        int[] dp = new int[end + 2];
        dp[end] = nums[end];
        if(start == end) return dp[start];
        dp[end - 1] = Math.max(nums[end - 1], nums[end]);
        for(int i = end-2; i >=start; i--) {
            int take = nums[i] + dp[i+2];
            int nottake = dp[i+1];
            dp[i] = Math.max(take, nottake);
        }

        return dp[start];
    }
}
