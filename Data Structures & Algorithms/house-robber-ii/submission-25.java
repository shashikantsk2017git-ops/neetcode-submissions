class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        // int first = robbingLatestDP(nums, 0, nums.length-2, new int[n][n]);
        // int second = robbingLatestDP(nums, 1, nums.length-1, new int[n][n]);

        int first = robbingLoop(nums, 0, nums.length-2);
        int second = robbingLoop(nums, 1, nums.length-1);

        return Math.max(first, second);
    }

    public int robbingLatestDP(int[] nums, int first, int last, int[][] dp) {
        if(first > last) {
            return 0;
        }
        if(dp[first][last] != 0) return dp[first][last];
        int take = nums[first] + robbingLatestDP(nums, first+2, last, dp);
        int notTake= robbingLatestDP(nums, first+1, last, dp);

        return dp[first][last] = Math.max(take, notTake);
    }

    public int robbingLatest(int[] nums, int first, int last) {
        int prv1 = nums[first];
        int prv2 = 0;
        
        for(int i = first+1; i <= last; i++) {
            int curr = 0;
            if(i-2 < 0) curr = prv1;
            else curr = Math.max(nums[i]+prv2, prv1);
            prv2 = prv1;
            prv1 = curr;
        }
        return prv1;
    }

    public int robbingLoop(int[] nums, int start, int end) {
        int prev1 = nums[end];
        if(start == end) return prev1;
        int prev2 = Math.max(nums[end - 1], nums[end]);

    
        for(int i = end-2; i >=start; i--) {
            int take = nums[i] + prev1;
            int nottake = prev2;
            prev2 = Math.max(take, nottake);
            prev1 = nottake;
        }

        return prev2;
    }
}
