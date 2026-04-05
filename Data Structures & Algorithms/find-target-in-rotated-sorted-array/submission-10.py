import bisect

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        pivot = self.get_pivot(nums)
        print(pivot)

        if target >= nums[pivot] and target <= nums[-1]:
            found_index = bisect.bisect_left(nums, target, pivot, len(nums))
        else:
            found_index = bisect.bisect_left(nums, target, 0, pivot)
        
        return found_index if found_index < len(nums) and nums[found_index] == target else -1
    
    def get_pivot(self, nums : List[int]) -> int:
        left, right = 0, len(nums) - 1
        end = len(nums) - 1
        pivot_index = 0

        while right >= left :
            mid = (left + right) // 2
            if nums[mid] <= nums[end]:
                pivot_index = mid
                right = mid - 1
            else:
                left = mid + 1

        return left