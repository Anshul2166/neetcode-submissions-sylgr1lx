class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        # [2], [2, 2], [2, 5] ....
        # [2, 2, 2], [2, 2, 5], [2, 5, 2]

        list_of_lists = []

        def combination_backtrack(nums: List[int], target: int, index : int, curr_list : List[int], list_of_lists : List[List[int]] ) -> None:
            sum_list = sum(curr_list)

            # List became greater than target
            if sum_list > target:
                return 
            
            # Sum list is same as target -> Goal achieved
            if sum_list == target:
                list_of_lists.append(curr_list.copy())
                return

            # Reached end of list
            if index == len(nums):
                return
            
            # pick this element
            curr_list.append(nums[index])
            combination_backtrack(nums, target, index, curr_list, list_of_lists)
            curr_list.pop()

            # don't pick this
            combination_backtrack(nums, target, index + 1, curr_list, list_of_lists)
        
        combination_backtrack(nums, target, 0, [], list_of_lists)
        return list_of_lists
