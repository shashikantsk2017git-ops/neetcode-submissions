class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCost(cost, 0, new int[cost.length]), 
        minCost(cost, 1, new int[cost.length]));
    }

    private int minCost(int[] cost, int ind) {
        if(ind >= cost.length) {
            return 0;
        }
        //1 step
        int one = minCost(cost, ind+1);

        //2 step
        int two = minCost(cost, ind+2);

        return cost[ind] + Math.min(one, two);
    }

    private int minCost(int[] cost, int ind, int[] dp) {
        if(ind >= cost.length) {
            return 0;
        }
        if(dp[ind] != 0) return dp[ind];
        //1 step
        int one = minCost(cost, ind+1, dp);

        //2 step
        int two = minCost(cost, ind+2, dp);

        return dp[ind] = cost[ind] + Math.min(one, two);
    }
}
