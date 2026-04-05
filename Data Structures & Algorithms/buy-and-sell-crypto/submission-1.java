class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        
        int minPriceTillNow = prices[0], maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            // sell at current day, buy at the day where price was minimal before that day (minPriceTillNow)
            maxProfit = Math.max(maxProfit, prices[i] - minPriceTillNow);

            // Update minPriceTillNow
            minPriceTillNow = Math.min(minPriceTillNow, prices[i]);
        }

        return maxProfit;
    }
}
