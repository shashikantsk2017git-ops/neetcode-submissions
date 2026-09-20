class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;

        for(int price: prices) {
            int profit = price - buy;
            maxProfit = Math.max(profit, maxProfit);
            buy = Math.min(buy, price);
        }
        return maxProfit;
    }
}
