class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(right > left){
            int currSum = numbers[right] + numbers[left];
            if(currSum > target){
                right--;
            }else if(currSum < target){
                left++;
            }else{
                int[] res = {left + 1, right + 1};
                return res;
            }
        }
        int[] res = {-1, -1};
        return res;
    }
}
