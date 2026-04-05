class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rowIndex = getRowIndex(matrix, target);

        if(rowIndex == -1){
            return false;
        }

        int columnIndex = getColumnIndex(matrix[rowIndex], target);

        return columnIndex >= 0 ? true : false;
    }

    int getRowIndex(int[][] matrix, int target){
        int left = 0, right = matrix.length - 1;

        while(right >= left){
            int mid = (left + right)/2;
            
            if((matrix[mid][0] <= target) && ((mid + 1) == matrix.length || matrix[mid + 1][0] > target)){
                return mid;
            }else if(matrix[mid][0] > target){
                right = mid - 1;
            }else if(matrix[mid][0] < target){
                left = mid + 1;
            }
        }

        return -1;
    }

    int getColumnIndex(int[] arr, int target){
        int left = 0, right = arr.length - 1;

        while(right >= left){
            int mid = (left + right)/2;

            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return -1;
    }
}
