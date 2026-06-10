class Solution {
    public int rob(int[] nums) {
        // return robbing(nums, 0);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        // return robbing(nums, 0, dp);

        return robbingLoop(nums);
    }

    public int robbing(int[] nums, int ind) {
        if(ind > nums.length-1) return 0;
        //take
        int take = nums[ind] + robbing(nums, ind+2);

        //not take
        int nottake = robbing(nums, ind+1);

        return Math.max(take, nottake);
    }

    public int robbing(int[] nums, int ind, int[] dp) {
        if(ind > nums.length-1) return 0;
        if(dp[ind] != -1) return dp[ind];
        //take
        int take = nums[ind] + robbing(nums, ind+2);

        //not take
        int nottake = robbing(nums, ind+1);

        return dp[ind] = Math.max(take, nottake);
    }

    public int robbingLoop(int[] nums) {
        int[] dp = new int[nums.length+1];

        dp[nums.length-1] = nums[nums.length-1];

        for(int i = nums.length-1; i >=0; i--) {
            int take = nums[i];
            if(i != nums.length-1)
                take = nums[i] + dp[i+2];
            int nottake = dp[i+1];
            dp[i] = Math.max(take, nottake);
        }
        return dp[0];
    }
}
