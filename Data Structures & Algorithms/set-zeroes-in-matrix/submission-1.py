class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    self.markInfinity(matrix, i, j)
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == "inf":
                    matrix[i][j] = 0
        
    def markInfinity(self, matrix : List[List[int]], i : int, j : int) -> None:

        for col in range(len(matrix[0])):
            if matrix[i][col] != 0:
                matrix[i][col] = "inf"
        
        for row in range(len(matrix)):
            if matrix[row][j] != 0:
                matrix[row][j] = "inf"
        