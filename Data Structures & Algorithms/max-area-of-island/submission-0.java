class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j, 0);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col, int currArea){
        int[] location = {-1, 0, 1, 0, -1};

        grid[row][col] = 0;
        currArea++;

        for(int i = 0; i < location.length - 1; i++){
            int currRow = row + location[i];
            int currCol = col + location[i+1];

            if(currRow >= 0 && currRow < grid.length && currCol >=0 && currCol < grid[0].length && grid[currRow][currCol] == 1){
                currArea = dfs(grid, currRow, currCol, currArea);
            }
        }

        return currArea;
    }


}
