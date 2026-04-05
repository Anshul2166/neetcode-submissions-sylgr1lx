class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        if len(matrix) == 0:
            return matrix
        
        # transpose
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if i >= j:
                    matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        
        # reverse each row
        for i in range(len(matrix)):
            matrix[i].reverse()
        