class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;

        int maxArea = 0;

        while(right > left){
            int currArea = (right - left) * Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, currArea);

            if(heights[left] > heights[right]){
                right--;
            }else{
                left++;
            }
        }

        return maxArea;
    }
}
