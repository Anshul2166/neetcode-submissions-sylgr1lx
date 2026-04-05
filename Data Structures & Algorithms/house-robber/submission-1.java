class Solution {
    public int rob(int[] nums) {
        int[] money = new int[nums.length];
        int n = nums.length;

        if(n == 1)
            return nums[0];

        money[0] = nums[0];
        money[1] = nums[1];

        for(int i = 2; i < n; i++){
            money[i] = Math.max(nums[i] + money[i-2], nums[i] + (i >= 3 ? money[i-3] : 0));
        }

        return Math.max(money[n-1], money[n-2]);
    }
}
