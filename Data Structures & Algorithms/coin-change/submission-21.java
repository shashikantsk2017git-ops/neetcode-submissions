class Solution {
    public int coinChange(int[] coins, int amount) {
        return calculateCoins(coins, 0, amount);
    }

    public int calculateCoins(int[] coins, int ind, int target) {
        if(target == 0) return 0;
        if(ind >= coins.length || target < 0) return -1;
        //take
        int take = 1 + calculateCoins(coins, ind, target-coins[ind]);
        if(take == 0) take = -1;
        
        //nottake
        int nottake = calculateCoins(coins, ind+1, target);
        if(take == -1 )return nottake;
        if(nottake == -1) return take;
        return Math.min(take, nottake);
    }
}