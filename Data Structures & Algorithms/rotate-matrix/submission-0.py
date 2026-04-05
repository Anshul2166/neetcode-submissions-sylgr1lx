class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        if len(matrix) == 0:
            return matrix

        rotated = [[0] * len(matrix[0]) for i in range(len(matrix))]
        
        # transpose
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                rotated[i][j] = matrix[j][i]
        
        # reverse each row
        for i in range(len(matrix)):
            rotated[i].reverse()

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                matrix[i][j] = rotated[i][j]
        