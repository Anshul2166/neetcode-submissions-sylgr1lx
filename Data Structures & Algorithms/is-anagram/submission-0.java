class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];

        // Different length string can't be anagrams
        if(s.length() != t.length()){
            return false;
        }

        // Both s and t are same length
        for(int i = 0; i < s.length(); i++){
            // Increment counter for character found in s
            arr[s.charAt(i)-'a']++;

            // Decrement counter for character found in t
            arr[t.charAt(i)-'a']--;
        }

        // Check if any element in arr is non-zero
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}
