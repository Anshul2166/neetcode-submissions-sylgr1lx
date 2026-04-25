class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        ways = [ [0] * n for i in range(m)]

        for i in range(m):
            for j in range(n):
                if i == 0 or j == 0:
                    ways[i][j] = 1
                else:
                    ways[i][j] = ways[i-1][j] + ways[i][j-1]
        
        return ways[m-1][n-1]
        