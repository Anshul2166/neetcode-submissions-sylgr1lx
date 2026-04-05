class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        
        left = right = 0

        jumps = 0

        while right < len(nums) - 1:
            furthest = 0
            for i in range(left, right + 1):
                furthest = max(furthest, i + nums[i])
            
            left = right + 1
            right = furthest
            jumps += 1

        return jumps