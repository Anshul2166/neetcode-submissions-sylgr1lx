class Solution:
    def findMin(self, nums: List[int]) -> int:
        pivot = -1
        left, right = 0, len(nums) - 1
        end = right

        while right >= left:
            mid = (left + right)//2
            if nums[mid] <= nums[end]:
                pivot = mid
                right = mid - 1
            else:
                left = mid + 1
        
        return nums[pivot]
        