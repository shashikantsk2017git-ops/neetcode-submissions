class Solution {
    public int rob(int[] nums) {
        // return robbing(nums, 0);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        // return robbing(nums, 0, dp);

        return robbingloopN(nums);
    }

    public int robbing(int[] nums, int ind) {

        if(ind >= nums.length) {
            return 0;
        }
        //take
        int take = nums[ind]+robbing(nums, ind+2);
        //Not take
        int notTake = robbing(nums, ind+1);

        return Math.max(take, notTake);
    }

    public int robbing(int[] nums, int ind, int[] dp) {

        if(ind >= nums.length) {
            return 0;
        }
        if(dp[ind] != -1) return dp[ind];
        //take
        int take = nums[ind]+robbing(nums, ind+2);
        //Not take
        int notTake = robbing(nums, ind+1);

        return dp[ind] = Math.max(take, notTake);
    }

    public int robbingloop(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        dp[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length - 2; i >=0; i--) {
            //take
            int take = nums[i];
            if(i != nums.length - 2)
                take += dp[i+2];
            //Not take
            int notTake = dp[i+1];

            dp[i] = Math.max(take, notTake);
        }
        return dp[0];
    }

    public int robbingloopN(int[] nums) {
        
        int prev1 = nums[nums.length-1];
        int prev2 = 0;
        for(int i = nums.length - 2; i >=0; i--) {
            //take
            int take = nums[i];
            if(i != nums.length - 2)
                take += prev2;
            //Not take
            int notTake = prev1;

            prev1 = Math.max(take, notTake);
            prev2 = notTake;
        }
        return prev1;
    }
}
