class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        System.out.println(pivot);
        if(nums[pivot] <= target && nums[nums.length - 1] >= target){
            // target between pivot and end
            return binarySearch(nums, target, pivot, nums.length - 1);
        }else{
            return binarySearch(nums, target, 0, pivot - 1);
        }
    }

    public int findPivot(int[] nums){
        int left = 0, right = nums.length - 1;
        int lastFoundIndex = -1;

        while(right >= left){
            int mid = (left + right)/2;
            if(nums[mid] <= nums[nums.length - 1]){
                lastFoundIndex = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return lastFoundIndex;
    }

    public int binarySearch(int[] nums, int target, int start, int end){
        while(end >= start){
            int mid = (start + end)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return -1;
    }
}
