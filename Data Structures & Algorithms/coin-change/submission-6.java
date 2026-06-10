class Solution {
    public int coinChange(int[] coins, int amount) {
        // return coinCount(coins, amount, 0);
        
        int[][] dp = new int[amount+1][coins.length];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return coinCount(coins, amount, 0, dp);
        // int res =  cCount(coins, amount, 0);
        // return res >= (int)1e9 ? -1 : res;
    }

    public int coinCount(int[] coins, int target, int ind, int[][] dp) {

        if (ind > coins.length - 1 || target <= 0) {
            if (target == 0) return 0; 
            return -1;
        }
        if(dp[target][ind] != -1) return dp[target][ind];
        //take
        int take = coinCount(coins, target - coins[ind], ind);
        if (take != -1) take += 1; 

        //not take
        int nottake = coinCount(coins, target, ind + 1);

        if (take == -1) return dp[target][ind] = nottake;
        if (nottake == -1) return dp[target][ind] = take;
        return dp[target][ind] = Math.min(take, nottake);
    }

    public int coinCount(int[] coins, int target, int ind) {

        if (ind > coins.length - 1 || target <= 0) {
            if (target == 0) return 0; 
            return -1;
        }

        //take
        int take = coinCount(coins, target - coins[ind], ind);
        if (take != -1) take += 1; 

        //not take
        int nottake = coinCount(coins, target, ind + 1);

        if (take == -1) return nottake;
        if (nottake == -1) return take;
        return Math.min(take, nottake);
    }

    public int cCount(int[] c, int target, int index) {
        if(index == c.length-1) {
            if(target % c[index] == 0) 
                return target/c[index];
            return (int)1e9;
        }

        int take = (int) 1e9;
        if(target>=c[index]) {
            take = 1 + cCount(c, target-c[index], index);
        }

        int notTake = cCount(c, target, index+1);
        return Math.min(take, notTake);
    }
}