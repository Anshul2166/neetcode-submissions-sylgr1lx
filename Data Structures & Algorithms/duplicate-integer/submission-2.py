class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        set_duplicate = set()
        for num in nums:
            if num in set_duplicate:
                return True
            set_duplicate.add(num)
        return False
        