class Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        dp = [0] * (n + 1)

        dp[0] = 1

        for i in range(n):
            curr_int = int(s[i])
            
            if curr_int != 0:
                dp[i + 1] = dp[i]

            if i > 0:
                last_int = int(s[i-1])

                if last_int == 1 or (last_int == 2 and 0 <= curr_int <= 6):
                    dp[i + 1] += dp[i-1]
        
        return dp[n]
        