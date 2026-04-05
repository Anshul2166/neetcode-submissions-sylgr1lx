class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    num++;
                    dfs(grid, i, j);
                }
            }
        }

        return num;
    }

    public void dfs(char[][] grid, int row, int col){
        int[] location = {-1, 0, 1, 0, -1};

        grid[row][col] = '0';

        for(int i = 0; i < location.length - 1; i++){
            int currRow = row + location[i];
            int currCol = col + location[i+1];

            if(currRow >= 0 && currRow < grid.length && currCol >=0 && currCol < grid[0].length && grid[currRow][currCol] == '1'){
                dfs(grid, currRow, currCol);
            }
        }
    }
}
