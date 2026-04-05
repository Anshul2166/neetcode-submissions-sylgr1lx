class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longestSequenceLength = 0;

        for(int num : nums){
            int currSequenceLength = 1;
            longestSequenceLength = Math.max(longestSequenceLength, currSequenceLength);
            if(set.contains(num-1)){
                continue;
            }
            while(set.contains(num+1)){
                currSequenceLength++;
                longestSequenceLength = Math.max(longestSequenceLength, currSequenceLength);
                num++;
            }
        }
        return longestSequenceLength;
    }
}
