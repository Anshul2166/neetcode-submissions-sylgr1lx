class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;

        // check for row repeatition
        for(int i = 0; i < rows; i++){
            Set<Character> currRowNums = new HashSet<Character>();
            for(int j = 0; j < cols; j++){
                if(board[i][j]=='.')
                    continue;
                if(currRowNums.contains(board[i][j])){
                    return false;
                }
                currRowNums.add(board[i][j]);
            }
        }

        // check for column repeatition
        for(int j = 0; j < cols; j++){
            Set<Character> currColNums = new HashSet<Character>();
            for(int i = 0; i < rows; i++){
                if(board[i][j]=='.')
                    continue;
                if(currColNums.contains(board[i][j])){
                    return false;
                }
                currColNums.add(board[i][j]);
            }
        }

        for(int i = 1; i < rows; i = i + 3){
            for(int j = 1; j < cols; j = j + 3){
                if(!isCurrBoxValid(board, i, j)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isCurrBoxValid(char[][] board, int row, int col){
        Set<Character> currBox = new HashSet<Character>();
        int startRow = row - 1, startCol = col - 1;

        for(int i = startRow; i < startRow + 3; i++){
            for(int j = startCol; j < startCol + 3; j++){
                if(board[i][j]=='.')
                    continue;
                if(currBox.contains(board[i][j]))
                    return false;
                currBox.add(board[i][j]);
            }
        }

        return true;
    }
}
