class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:

        def dfs(grid : List[List[int]], i : int, j : int, dist : int) -> None:
            dist += 1
            locations = [(-1, 0), (0, 1), (1, 0), (0, -1)]

            for x,y in locations:
                curr_row = i + x
                curr_col = j + y

                if 0 <= curr_row < len(grid) and 0 <= curr_col < len(grid[0]) and grid[curr_row][curr_col] > 0:
                    if grid[curr_row][curr_col] > dist:
                        grid[curr_row][curr_col] = dist
                        dfs(grid, curr_row, curr_col, dist)

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0:
                    dfs(grid, i, j, 0)
        