class Solution {
    public String longestPalindrome(String s) {
        int[] palindrome = new int[s.length()];

        int maxLenFound = 1;
        String maxStringFound = String.valueOf(s.charAt(0));

        for(int start = 0; start < s.length(); start++){
            for(int end = start + 1; end < s.length(); end++){
                int currLen = end - start + 1;
                if(maxLenFound >= currLen){
                    continue;
                }

                String substr = s.substring(start, end + 1);
                if(isValidPalindrome(substr)){
                    maxLenFound = substr.length();
                    maxStringFound = substr;
                }
            }
        }

        return maxStringFound;
    }

    public boolean isValidPalindrome(String str){
        int left = 0, right = str.length() - 1;

        while(right > left){
            if(str.charAt(left) != str.charAt(right))
                return false;
            right--;
            left++;
        }

        return true;
    }
}
