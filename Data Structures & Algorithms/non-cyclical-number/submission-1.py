class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()
        while True:
            square_digits = 0
            while n != 0:
                square_digits += (n % 10) ** 2
                n = n//10
            
            if square_digits == 1:
                return True
            else:
                if square_digits in seen:
                    return False
                seen.add(square_digits)
            
            n = square_digits

