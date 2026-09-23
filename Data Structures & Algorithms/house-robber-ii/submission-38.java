class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        // //Taking first
        // int first = maxRob(nums, 0, nums.length-2);
        // //Taking last
        // int last = maxRob(nums, 1, nums.length-1);

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        //Taking first
        int first = maxRob(nums, 0, nums.length-2, dp);
        //Taking last
        Arrays.fill(dp, -1);
        int last = maxRob(nums, 1, nums.length-1, dp);

        return Math.max(first, last);
    }

    private int maxRob(int nums[], int strInd, int lastInd) {
        if(strInd > lastInd) return 0;
        //choosing first one
        int first = nums[strInd] + maxRob(nums, strInd+2, lastInd);

        //not choosing first one
        int notFirst = maxRob(nums, strInd+1, lastInd);

        return Math.max(first, notFirst);
    }
    
    private int maxRob(int nums[], int strInd, int lastInd, int[] dp) {
        if(strInd > lastInd) return 0;
        if(dp[strInd] != -1) return dp[strInd];
        //choosing first one
        int first = nums[strInd] + maxRob(nums, strInd+2, lastInd, dp);

        //not choosing first one
        int notFirst = maxRob(nums, strInd+1, lastInd, dp);

        return dp[strInd] = Math.max(first, notFirst);
    }
}
