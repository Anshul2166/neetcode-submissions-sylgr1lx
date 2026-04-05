class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_price_till_now, max_profit = prices[0], 0
        for price in prices:
            max_profit = max(price - min_price_till_now, max_profit) 
            min_price_till_now = min(min_price_till_now, price)
        return max_profit
        