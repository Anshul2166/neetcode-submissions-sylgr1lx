class Solution {
    public int maxSubArray(int[] nums) {
        int sum = - 1001;
        int maxSum = sum;

        for(int num : nums){
            sum = Math.max(sum + num, num);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
