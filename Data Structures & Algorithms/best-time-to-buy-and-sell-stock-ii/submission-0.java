class Solution {
    public int maxProfit1(int[] prices) {
        int drop = prices[0];
        int jump = prices[0];
        int maxProfit = 0;

        for(int i = 0; i < prices.length - 1; i++) {
            while(i < prices.length-1 && prices[i] >= prices[i+1]) i++;
            drop = prices[i];

            while(i < prices.length -1 && prices[i] <= prices[i+1]) i++;
            jump = prices[i];

            maxProfit += jump - drop;
        }

        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int drop = prices[0];
        int jump = prices[0];
        int maxProfit = 0;

        for(int i = 0; i < prices.length - 1; i++) {
            // while(i < prices.length-1 && prices[i] >= prices[i+1]) i++;
            drop = prices[i];

            // while(i < prices.length -1 && prices[i] <= prices[i+1]) i++;
            jump = prices[i+1];

            maxProfit += Math.max(0, jump - drop);
        }

        return maxProfit;
    }


    public int maxProfit0(int[] prices) {
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            profit += Math.max(0,prices[i]-prices[i-1]);
        }
        return profit;
    }
}