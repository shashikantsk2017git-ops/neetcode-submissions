class Solution {
    public int maxProfit(int[] prices) {
        int bear = 0;
        int bull = 0;
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            bear = prices[i];
            bull = prices[i+1];

            maxProfit += Math.max(0, bull - bear);
        }

        return maxProfit;
    }
}