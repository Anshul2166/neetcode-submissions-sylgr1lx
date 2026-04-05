class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int[] right = new int[nums.length];

        product[0] = 1;
        right[nums.length - 1] = 1;

        for(int i = nums.length - 2; i >=0 ; i--){
            right[i] = nums[i+1] * right[i+1];
        }

        for(int i = 1; i < nums.length; i++){
            product[i] = nums[i-1] * product[i-1];
        }

        for(int i = 0; i < nums.length; i++){
            product[i] *= right[i];
        }

        return product; 
    }
}  
