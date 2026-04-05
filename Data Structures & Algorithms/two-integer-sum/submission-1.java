class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(indexMap.containsKey(diff)){
                int[] res = {indexMap.get(diff), i};
                return res;
            }
            indexMap.put(nums[i], i);
        }
        int[] def = {-1, -1};
        return def;
    }
}
