class Solution {
    public int coinChange(int[] coins, int amount) {
        // return coinCount(coins, amount, 0);

        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        // return coinCount(coins, amount, 0, dp);
        return coinCountLoop(coins, amount, dp);
        // return coinCountLoop(coins, amount);
        // int res =  cCount(coins, amount, 0);
        // return res >= (int)1e9 ? -1 : res;
    }
    public int calculateCoin(int[] coins, int amount, int ind) {
        if(ind > coins.length-1 || amount <= 0) {
            if(amount == 0) return 0;
            return -1;
        }

        //take
        int take = 1 + calculateCoin(coins, amount-coins[ind], ind);
        if(take == 0) take = -1;
        //not take
        int nottake = calculateCoin(coins, amount, ind+1);

        if(take == -1) return nottake;
        if(nottake == -1) return take;

        return Math.min(take, nottake);
    }

    public int coinCount(int[] coins, int target, int ind) {
        if (ind > coins.length - 1 || target <= 0) {
            if (target == 0)
                return 0;
            return -1;
        }

        // take
        int take = coinCount(coins, target - coins[ind], ind);
        if (take != -1)
            take += 1;

        // not take
        int nottake = coinCount(coins, target, ind + 1);

        if (take == -1)
            return nottake;
        if (nottake == -1)
            return take;
        return Math.min(take, nottake);
    }

    public int coinCount(int[] coins, int target, int ind, int[][] dp) {
        if (ind > coins.length - 1 || target <= 0) {
            if (target == 0)
                return 0;
            return -1;
        }
        if (dp[target][ind] != -1)
            return dp[target][ind];
        // take
        int take = coinCount(coins, target - coins[ind], ind);
        if (take != -1)
            take += 1;

        // not take
        int nottake = coinCount(coins, target, ind + 1);

        if (take == -1)
            return dp[target][ind] = nottake;
        if (nottake == -1)
            return dp[target][ind] = take;
        return dp[target][ind] = Math.min(take, nottake);
    }

    public int coinCountLoop(int[] coins, int target, int[][] dp) {
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        //check for each coin and see if able to acheive target amount
        for(int ind = coins.length-1; ind >=0; ind--) {
            for(int amt = 1; amt <= target; amt++) {
                //take
                int take = -1;
                //current coin <= amt and prev dp value with prev amt and ind
                if(coins[ind] <= amt && dp[amt-coins[ind]][ind] != -1)
                    take = 1 + dp[amt - coins[ind]][ind];

                //not take
                int nottake = dp[amt][ind + 1];
                if(take == -1) dp[amt][ind] = nottake;
                else if(nottake == -1) dp[amt][ind] = take;
                else dp[amt][ind] = Math.min(take, nottake);
            }
        }
        return dp[target][0];
    }

    public int cCount(int[] c, int target, int index) {
        if (index == c.length - 1) {
            if (target % c[index] == 0)
                return target / c[index];
            return (int) 1e9;
        }

        int take = (int) 1e9;
        if (target >= c[index]) {
            take = 1 + cCount(c, target - c[index], index);
        }

        int notTake = cCount(c, target, index + 1);
        return Math.min(take, notTake);
    }

    public int coinCountLoop(int[] coins, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);

        // base case: amt=0 needs 0 coins
        dp[0] = 0;

        for (int ind = coins.length - 1; ind >= 0; ind--) {
            for (int amt = 1; amt <= target; amt++) {
                // take → dp[amt - coins[ind]][ind] becomes dp[amt - coins[ind]]
                int take = -1;
                if (coins[ind] <= amt && dp[amt - coins[ind]] != -1)
                    take = dp[amt - coins[ind]] + 1;

                // not take → dp[amt][ind+1] is just dp[amt] from previous ind iteration
                int nottake = dp[amt];

                if (take == -1)
                    dp[amt] = nottake;
                else if (nottake == -1)
                    dp[amt] = take;
                else
                    dp[amt] = Math.min(take, nottake);
            }
        }

        return dp[target];
    }
}