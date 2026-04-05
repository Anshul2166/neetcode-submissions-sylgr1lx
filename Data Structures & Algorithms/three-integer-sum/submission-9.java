class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++){

            if(i > 0 && nums[i] == nums[i-1])
                continue;

            // fix first element
            int target = 0 - nums[i];
            int second = i + 1, third = nums.length - 1;

            while(third > second){
                int currSum = nums[second] + nums[third];
                if(currSum == target){
                    List<Integer> currList = new ArrayList<>(Arrays.asList(nums[i], nums[second], nums[third]));
                    list.add(currList);
                    while(third > second && nums[second + 1] == nums[second]){
                        second++;
                    }
                    second++;
                    while(third > second && nums[third - 1] == nums[third]){
                        third--;
                    }
                    third--;
                }else if(currSum > target){
                    third--;
                }else{
                    // currSum < target
                    second++;
                }
            }
        }

        return list;
    }
}
