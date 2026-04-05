class Solution {
    public int[] productExceptSelf(int[] nums) {

        // Get product of all elements in num before that index
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for(int i = 1; i < nums.length; i++){
            // current value is previous index in num * product of all values to left of prev value
            res[i] = nums[i-1] * res[i-1];
        }

        int right = 1;

        for(int i = nums.length - 1; i >= 0; i--){
            res[i] = right * res[i];
            right = right * nums[i];
        }

        return res;
    }
}  
