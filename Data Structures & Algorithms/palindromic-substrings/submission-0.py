class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        dp = [[True] * n for _ in range(n)]

        num_palindrome = n

        for i in range(n - 2, -1, -1):
            for j in range(i + 1, n):
                dp[i][j] = False
                if s[i] == s[j]:
                    dp[i][j] = dp[i+1][j-1]

                    if dp[i][j]:
                        num_palindrome += 1
        
        return num_palindrome
                        