class Solution {
    public int rob(int[] nums) {
        // return maxRob(nums, 0);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxRob(nums, 0, dp);
    }

    private int maxRob(int[] nums, int ind) {
        if(ind >= nums.length) return 0;
        //choose first house to rob
        int first =  nums[ind] + maxRob(nums, ind + 2);

        //Not choosing first house to rob
        int notFirst = maxRob(nums, ind+1);

        return Math.max(first, notFirst);
    }

    private int maxRob(int[] nums, int ind, int[] dp) {
        if(ind >= nums.length) return 0;
        if(dp[ind] != -1) return dp[ind];
        //choose first house to rob
        int first =  nums[ind] + maxRob(nums, ind + 2, dp);

        //Not choosing first house to rob
        int notFirst = maxRob(nums, ind+1, dp);

        return dp[ind] = Math.max(first, notFirst);
    }
}
