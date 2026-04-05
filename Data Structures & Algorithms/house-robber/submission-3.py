class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        
        if n == 1:
            return nums[0]
        elif n == 2:
            return max(nums)
        elif n == 3:
            return max(nums[0] + nums[2], nums[1])
        
        result = [0] * len(nums)
        result[0] = nums[0]
        result[1] = nums[1]
        result[2] = nums[0] + nums[2]

        for i in range(3, n):
            result[i] = nums[i] + max(result[i-3], result[i - 2])
        
        return max(result[n - 2], result[n -1])
    