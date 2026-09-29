class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        // return calculateCoin(coins, amount, 0);
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return calculateCoin(coins, amount, 0, dp);
    }

    public int calculateCoin(int[] coins, int amount, int ind) {
        if(amount == 0) return 1;
        if(ind > coins.length-1 || amount < 0) {
            return 0;
        }

        //take
        int take = calculateCoin(coins, amount-coins[ind], ind);
        //not take
        int next = ind + 1;
        while(next < coins.length && coins[next] == coins[ind]) {
            next++;   
        }
        int nottake = calculateCoin(coins, amount, next);

        return take + nottake;
    }

    public int calculateCoin(int[] coins, int amount, int ind, int[][] dp) {
        if(amount == 0) return 1;
        if(ind > coins.length-1 || amount < 0) {
            return 0;
        }
        if(dp[amount][ind] != -1) return dp[amount][ind];
        //take
        int take = calculateCoin(coins, amount-coins[ind], ind, dp);
        //not take
        int next = ind + 1;
        while(next < coins.length && coins[next] == coins[ind]) {
            next++;   
        }
        int nottake = calculateCoin(coins, amount, next, dp);

        return dp[amount][ind] = take + nottake;
    }
}

