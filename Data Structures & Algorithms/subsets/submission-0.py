class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        list_of_lists = []
        
        def subset_add(nums: List[int], index : int, curr_list : List[int], list_of_lists : List[List[int]]) -> None:
            if index == len(nums):
                # Reached last element in array
                list_of_lists.append(curr_list.copy())
                return

            # pick
            curr_list.append(nums[index])
            subset_add(nums, index + 1, curr_list, list_of_lists)
            curr_list.remove(nums[index])

            # don't pick
            subset_add(nums, index + 1, curr_list, list_of_lists)
        
        subset_add(nums, 0, [], list_of_lists)
        return list_of_lists

        