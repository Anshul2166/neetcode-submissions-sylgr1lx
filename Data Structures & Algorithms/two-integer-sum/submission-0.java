class Solution {
    public int[] twoSum(int[] nums, int target) {
        // value -> List of indexes
        Map<Integer, List<Integer>> indexMap = new HashMap<Integer, List<Integer>>();

        // Construct the map
        for(int i = 0; i < nums.length; i++){
            if(indexMap.containsKey(nums[i])){
                // Value already exists in map
                indexMap.get(nums[i]).add(i);
            }else{
                // Key does not exist
                // Need a list and add entry to map
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                indexMap.put(nums[i], indexList);
            }
        }

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if(indexMap.containsKey(diff)){
                List<Integer> indexForCurrValue = indexMap.get(diff);
                // Second value exists
                if(diff == nums[i]){
                    // Both values are same
                    if(indexForCurrValue.size()==1){
                        continue;
                    }else{
                        int[] res = {i, indexForCurrValue.get(1)};
                        return res;
                    }
                }else{
                    int[] res = {i, indexForCurrValue.get(0)};
                    return res;
                }
            }
        }

        int[] res = {-1, -1};
        return res;
    }
}
