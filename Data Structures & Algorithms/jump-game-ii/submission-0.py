class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        
        reach = [10000] * len(nums)

        reach[0] = 0

        for index, num in enumerate(nums):
            for i in range(num):
                curr_index = index + i + 1
                if curr_index < len(nums):
                    reach[curr_index] = min(reach[curr_index], 1 + reach[index])
        
        return reach[-1]