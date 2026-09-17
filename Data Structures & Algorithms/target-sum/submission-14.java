class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // return countWays(nums, 0, 0, target);
        int[][] dp = new int[nums.length][1000];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        // return countWays(nums, 0, 0, target, dp);
        return findTargetSumRecursion(nums, target);
        // return countWays(nums, target);
    }

    private int countWays(int[] nums, int ind, int sum, int target) {
        if (ind == nums.length) {
            return sum == target ? 1 : 0;
        }
        // plus
        int plus = countWays(nums, ind + 1, sum + nums[ind], target);

        // minus
        int minus = countWays(nums, ind + 1, sum - nums[ind], target);

        return plus + minus;
    }

    private int countWays(int[] nums, int ind, int sum, int target, int[][] dp) {
        if (ind == nums.length) {
            return sum == target ? 1 : 0;
        }
        if (dp[ind][sum] != -1)
            return dp[ind][sum];

        int plus = countWays(nums, ind + 1, sum + nums[ind], target);
        int minus = countWays(nums, ind + 1, sum - nums[ind], target);

        return dp[ind][sum] = plus + minus;
    }

    private int countWays(int[] nums, int target) {
        int totalSum = 0;
        for(int num: nums) totalSum += num;

        if (Math.abs(target) > totalSum) return 0; 

        int offset = totalSum;              // shift so array index is never negative
        int width = 2 * totalSum + 1;        // valid real sums: -totalSum..totalSum


        int[][] dp = new int[nums.length + 1][width];
        dp[nums.length][target + offset] = 1; 

        for(int ind = nums.length-1; ind >= 0; ind--) {
            for(int sum = width-1; sum >=0; sum--) {

                int plus = (sum + nums[ind] < width) ? dp[ind+1][sum+nums[ind]] : 0;
                int minus = (sum - nums[ind] >= 0 )? dp[ind+1][sum - nums[ind]]: 0;

                dp[ind][sum] = plus + minus;
            }
        }
        return dp[0][0+offset];
    }

// Using recursion and DP
    public int findTargetSumRecursion(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        if (Math.abs(target) > totalSum) return 0;

        int offset = totalSum;
        int width = 2 * totalSum + 1;

        int[][] dp = new int[n][width];
        for (int[] row : dp) Arrays.fill(row, -1);

        return countWays(nums, 0, 0, target, dp, offset, width);
    }

    private int countWays(int[] nums, int ind, int sum, int target, int[][] dp, 
    int offset, int width) {
        if (ind == nums.length) {
            return sum == target ? 1 : 0;
        }

        int idx = sum + offset; // shift real sum -> valid array index

        if (dp[ind][idx] != -1)
            return dp[ind][idx];

        int plus = countWays(nums, ind + 1, sum + nums[ind], target, dp, offset, width);
        int minus = countWays(nums, ind + 1, sum - nums[ind], target, dp, offset, width);

        return dp[ind][idx] = plus + minus;
    }
}
