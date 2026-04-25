class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        from functools import cache
        @cache
        def dfs(day : int, holding_stock : int) -> int:
            if day >= len(prices):
                return 0
            
            max_profit = dfs(day + 1, holding_stock)

            if holding_stock:
                max_profit = max(max_profit, prices[day] + dfs(day + 2, 0))
            else:
                max_profit = max(max_profit, -prices[day] + dfs(day + 1, 1))
            return max_profit
        
        return dfs(0, 0)
        