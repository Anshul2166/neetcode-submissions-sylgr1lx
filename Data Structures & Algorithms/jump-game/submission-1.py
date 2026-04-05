class Solution:
    def canJump(self, nums: List[int]) -> bool:

        if len(nums) == 0:
            return False

        reach = [False] * len(nums)

        reach[0] = True

        for index, num in enumerate(nums):
            if not reach[index]:
                continue
            
            for i in range(num):
                if (index + i + 1) < len(nums):
                    reach[index + i + 1] = True
                else:
                    break
        
        return reach[-1]

        