class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(right >= left){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                // nums[mid] < target
                left = mid + 1;
            }
        }

        return -1;
    }
}

// -1 0 2 4 6 8
// left = 0, right = 5, mid = 2
// arr[mid] = 2 < target (3)
// left = mid + 1 = 3, right = 5

// mid = 4, arr[mid] = 6 > target(3)
// left = 3, right = 3
// mid = 3
