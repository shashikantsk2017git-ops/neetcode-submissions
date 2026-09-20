class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;

        for(int price: prices) {
            int profit = price - buy;
            if(maxProfit < profit) {
                maxProfit = profit;
            }
            buy = Math.min(buy, price);
        }
        return maxProfit;
    }
}
