class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        
        maxSum = sum = nums[0]
        
        for num in nums[1:]:
            take = sum + num
            pass_curr = num
            
            sum = max(take, pass_curr)
            maxSum = max(maxSum, sum)
        
        return maxSum
        