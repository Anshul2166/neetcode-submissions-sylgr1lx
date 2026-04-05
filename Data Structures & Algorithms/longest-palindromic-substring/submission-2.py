class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        dp = [[True] * n for _ in range(n)]
        
        max_length = 1
        start_ind, end_index = 0, 0

        for i in range(n - 2, -1, -1):
            for j in range(i + 1, n):
                dp[i][j] = False # Assume it's not a palindrome

                # If first and last char match, then check if inner string is palindrome or not
                if s[i] == s[j]:
                    dp[i][j] = dp[i + 1][j - 1]

                    # If it's a palindrome, check the max length and update if current one is greater
                    if dp[i][j] and (j - i + 1) > max_length:
                        max_length = j - i + 1
                        start_ind = i
                        end_index = j
        
        return s[start_ind : end_index + 1]
        