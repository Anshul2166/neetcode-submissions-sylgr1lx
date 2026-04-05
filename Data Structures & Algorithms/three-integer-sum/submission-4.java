class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int curr = nums[i];
            int target = 0 - curr;

            int left = i + 1, right = nums.length - 1;
            while(right > left){
                int sum = nums[right] + nums[left];
                if(sum > target){
                    right--;
                }else if(sum < target){
                    left++;
                }else{
                    List<Integer> currList = List.of(nums[i], nums[left], nums[right]);
                    list.add(currList);

                    while(right > left && nums[right-1] == nums[right])
                        right--;
                    while(right > left && nums[left+1] == nums[left])
                        left++;
                    right--;
                    left++;
                }
            }
        }
        return list;
    }
}
