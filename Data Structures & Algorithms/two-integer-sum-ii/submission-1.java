class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(right > left){
            int currSum = numbers[left] + numbers[right];
            if(currSum == target){
                int[] res = {left + 1, right + 1};
                return res;
            }else if(currSum > target){
                right--;
            }else{
                // currSum < target
                left++;
            }
        }
        int[] res = {-1, -1};
        return res;
    }
}
