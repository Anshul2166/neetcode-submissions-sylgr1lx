class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        from functools import cache

        @cache
        def dfs(index : int, sum_till_now : int):
            ways = 0
            if index >= len(nums):
                if sum_till_now == target:
                    ways += 1
                return ways
            
            ways += dfs(index + 1, sum_till_now + nums[index])
            ways += dfs(index + 1, sum_till_now - nums[index])

            return ways

        ways = dfs(0, 0)
        
        return ways
        