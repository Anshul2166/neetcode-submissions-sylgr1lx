class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        UP, DOWN, LEFT, RIGHT = 0, 1, 2, 3
        m, n = len(matrix), len(matrix[0])

        answer = []
        direction = RIGHT

        i, j = 0, 0

        up_wall, down_wall, left_wall, right_wall = 0, m, -1, n

        while len(answer) != m*n:
            if direction == RIGHT:
                while j < right_wall:
                    answer.append(matrix[i][j])
                    j += 1
                i, j = i + 1, j - 1 # one row down and last column
                direction = DOWN
                right_wall -= 1
            
            elif direction == DOWN:
                while i < down_wall:
                    answer.append(matrix[i][j])
                    i += 1
                i, j = i - 1, j - 1
                direction = LEFT
                down_wall -= 1
            
            elif direction == LEFT:
                while j > left_wall:
                    answer.append(matrix[i][j])
                    j -= 1
                i, j = i - 1, j + 1
                direction = UP
                left_wall += 1
            
            elif direction == UP:
                while i > up_wall:
                    answer.append(matrix[i][j])
                    i -= 1
                i, j = i + 1, j + 1
                direction = RIGHT
                up_wall += 1
        
        return answer
                