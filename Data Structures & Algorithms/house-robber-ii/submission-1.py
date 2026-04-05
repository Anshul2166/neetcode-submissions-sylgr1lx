class Solution:
    def rob(self, nums: List[int]) -> int:
        def rob_case(houses : List[int]) -> int:
            skip_current_house, rob_current_house = 0, 0

            # skip_current_house -> get max that we have seen till now -> max of skipping last house and robbing last house
            # rob_current_house -> skip last house and get this house
            for house in houses:
                skip_current_house, rob_current_house = max(skip_current_house, rob_current_house), skip_current_house + house
            return max(skip_current_house, rob_current_house)
        
        if len(nums) == 1:
            return nums[0]
            
        return max(rob_case(nums[1:]), rob_case(nums[0 : -1]))