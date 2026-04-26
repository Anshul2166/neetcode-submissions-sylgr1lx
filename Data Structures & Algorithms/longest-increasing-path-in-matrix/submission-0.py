class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:

        rows, cols = len(matrix), len(matrix[0])
        dp = [[-1] * cols for i in range(rows)]
        directions = [-1, 0, 1, 0, -1]

        def dfs(row : int, col : int) -> int:
            if dp[row][col] != -1:
                return dp[row][col]

            max_path = 0

            for i in range(len(directions) - 1):
                new_row = row + directions[i]
                new_col = col + directions[i + 1]

                if new_row < 0 or new_col < 0 or new_row >= rows or new_col >= cols or matrix[new_row][new_col] >= matrix[row][col]:
                    continue
                
                max_path = max(max_path, dfs(new_row, new_col))

            dp[row][col] = max_path + 1
            return dp[row][col]

        max_till_now = 0
        for i in range(rows):
            for j in range(cols):
                dp[i][j] = dfs(i, j)
                max_till_now = max(max_till_now, dp[i][j])
        
        return max_till_now
        