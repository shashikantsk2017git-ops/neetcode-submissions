class Solution {
    public int coinChange(int[] coins, int amount) {
       return calculateCoin(coins, amount, 0);
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
}