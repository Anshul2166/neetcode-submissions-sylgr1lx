class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        n = len(coins)
        dp = [[0] * (amount + 1) for i in range(n)]

        for i in range(n):
            for j in range(amount + 1):
                if j == 0:
                    dp[i][j] = 1
                else:
                    without_using = 0 if i == 0 else dp[i-1][j] 
                    if coins[i] > j:
                        dp[i][j] = without_using
                    else:
                        dp[i][j] = dp[i][j - coins[i]] + without_using
        
        return dp[n-1][amount]

        