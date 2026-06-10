class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int first = robbingLoop(nums, 0, nums.length-2, new int[nums.length+2]);
        int last = robbingLoop(nums, 1, nums.length-1, new int[nums.length+2]);

        return Math.max(first, last);
    }

    public int robbing(int[] nums, int ind, int last) {
        if(ind > last) return 0;
        int take = nums[ind] + robbing(nums, ind+2, last);
        int nottake = robbing(nums, ind+1, last);

        return Math.max(take, nottake);
    }

    public int robbing(int[] nums, int ind, int last, int[] dp) {
        if(ind > last) return 0;
        if(dp[ind] != 0) return dp[ind];
        int take = nums[ind] + robbing(nums, ind+2, last);
        int nottake = robbing(nums, ind+1, last);

        return dp[ind] = Math.max(take, nottake);
    }

    public int robbingLoop(int[] nums, int ind, int last, int[] dp) {
        dp[last] = nums[last];
        for(int i = last; i >= ind; i--) {
            int take = nums[i] + dp[i+2];
            int nottake = dp[i+1];
            dp[i] = Math.max(take, nottake);
        }
        return dp[ind];
    }

    public int robbingOpt(int[] nums, int ind, int last) {

        int prev1 = 0;
        int prev2 = 0;

        for(int i = last; i >=ind; i--) {
            int take = nums[i] + prev2;
            int nottake = prev1;
            prev2 = prev1;
            prev1 = Math.max(take, nottake);
        }
        return prev1;
    }
}
