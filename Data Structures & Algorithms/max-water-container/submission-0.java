class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;

        int maxArea = 0;

        while(left < right){
            maxArea = Math.max(maxArea, Math.min(heights[left], heights[right]) * (right - left) );
            if(heights[right] > heights[left]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }
}
