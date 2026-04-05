class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;

        while(right > left){
            char currRight = s.charAt(right);
            while(!isValid(currRight) && left < right){
                right--;
                currRight = s.charAt(right);
            }

            char currLeft = s.charAt(left);
            while(!isValid(currLeft) && left < right){
                left++;
                currLeft = s.charAt(left);
            }

            if(left >= right){
                break;
            }

            if(currRight != currLeft)
                return false;
            
            right--;
            left++;
        }
        return true;
    }

    boolean isValid(char c){
        if(c >= 'a' && c <= 'z')
            return true;
        else if (c >= '0' && c <= '9')
            return true;
        return false;
    }
}
