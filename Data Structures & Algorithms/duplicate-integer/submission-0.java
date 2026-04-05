class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> alreadySeen = new HashSet<Integer>();
        for(int num : nums){
            if(alreadySeen.contains(num)){
                // if already seen num, we got the duplicate value
                return true;
            }
            alreadySeen.add(num);
        }
        // if no match in set after full array traversed, then return false
        return false;
    }
}