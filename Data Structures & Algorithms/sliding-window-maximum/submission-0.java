class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 0; i < k; i++){
            queue.add(nums[i]);
        }

        int len = nums.length - k + 1;
        int[] res = new int[len];
        res[0] = queue.peek();
        
        for(int i = k; i < nums.length; i++){
            queue.add(nums[i]);
            queue.remove(nums[i-k]);
            res[i-k+1] = queue.peek();
        }

        return res;
    }
}
