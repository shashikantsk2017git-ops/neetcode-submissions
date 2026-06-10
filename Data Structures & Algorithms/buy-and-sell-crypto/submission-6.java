class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxp = Math.max(maxp, prices[i]-min);
        }
        return maxp;
    }
}
