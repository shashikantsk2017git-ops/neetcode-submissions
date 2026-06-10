class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int one = robbing(0, nums.length-2, nums);
        int last = robbing(1, nums.length-1, nums);
        return Math.max(one, last);
    }

    public int robbing(int first, int last, int[] nums) {

        int[] dp = new int[nums.length];
        dp[first] = nums[first];
        for(int i = first+1; i <= last; i++) {
            if(i-2 < 0) dp[i] = dp[i-1];
            else dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[last];
    }
}
