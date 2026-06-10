class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinCount(coins, amount, 0);
    }

    public int coinCount(int[] coins, int target, int ind) {

        if (ind > coins.length - 1 || target <= 0) {
            if (target == 0) return 0; 
            return -1;
        }

        
        int take = coinCount(coins, target - coins[ind], ind);
        if (take != -1) take += 1; 

      
        int nottake = coinCount(coins, target, ind + 1);


        if (take == -1) return nottake;
        if (nottake == -1) return take;
        return Math.min(take, nottake);
    }
}