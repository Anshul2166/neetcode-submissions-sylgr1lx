class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLengthFoundTillNow = 0;

        int left = 0, right = 0;

        if(s.length() == 1)
            return 1;
        else if(s.length() == 0)
            return 0;

        //deal with strings with length >= 2
        Set<Character> set = new HashSet<>();
        while(right < s.length()){
            
            // Remove characters from left till we can fit in the character at index = right
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            int currLen = right - left + 1;
            maxLengthFoundTillNow = Math.max(maxLengthFoundTillNow, currLen);

            right++;
        }

        return maxLengthFoundTillNow;
    }
}

// left = 0, right = 0
// left = 0, right = 1 set = {a}
// left = 0, right = 2 set = {a, b}
// left = 0, right = 3 set = {a, b, c}