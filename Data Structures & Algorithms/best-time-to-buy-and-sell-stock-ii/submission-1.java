/*
each day buy/sale
buy and sale on same day
n transactions allowed 
can't hold at more that one stock at a time

Maximum profit ?

*/
class Solution {
    public int maxProfit(int[] prices) {
        int vally = prices[0];
        int mountain = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length-1; i++) {
            
            vally = prices[i];
            mountain = prices[i+1];

            profit += Math.max(0, mountain - vally);
        }

        return profit;
    }
}