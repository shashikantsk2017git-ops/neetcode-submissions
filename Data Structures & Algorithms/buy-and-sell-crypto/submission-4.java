class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0;
        int mprice = prices[0];
        for(int price: prices) {
            if(price > mprice) {
                maxp = Math.max(maxp, (price - mprice));
            } else {
                mprice = price;
            }
        }
        return maxp;
    }
}
