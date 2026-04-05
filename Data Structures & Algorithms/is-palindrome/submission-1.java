class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while(right > left){
            while(right > left && !isAlphaNumeric(s, left)){
                left++;
            }
            while(right > left && !isAlphaNumeric(s, right)){
                right--;
            }
            if(left >= right)
                return true;
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            right--;
            left++;
        } 
        return true;
    }

    public boolean isAlphaNumeric(String s, int index){
        char chr = s.charAt(index);
        if((chr - 'a') >= 0 && (chr - 'a') < 26){
            return true;
        } else if((chr - '0') >= 0 && (chr - '0') < 10){
            return true;
        }
        return false;
    }
}
