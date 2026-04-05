class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() < 2){
            return s.length();
        }  

        // Deal with strings of length >= 2

        int[] freqArr = new int[26];
        for(int i = 0; i <= k; i++){
            freqArr[s.charAt(i) - 'A']++;
        }
        int left = 0, right = k + 1;

        int maxLengthFoundTillNow = k + 1;
        
        while(right < s.length()){
            freqArr[s.charAt(right) - 'A']++;
            
            // right - left + 1 -> currLength with left and right index
            // currLen - maxFreq of chara should be less than or equal to k
            // till that is not true, keep increasing left pointer
            while((right - left + 1) - maxFreq(freqArr) > k){
                freqArr[s.charAt(left) - 'A']--;
                left++;
            }

            // Get max of length found till now
            maxLengthFoundTillNow = Math.max(right - left + 1, maxLengthFoundTillNow);

            right++;
        }

        return maxLengthFoundTillNow;

    }

    int maxFreq(int[] freqArr){
        int maxFreqFound = 0;
        for(int freq : freqArr){
            maxFreqFound = Math.max(maxFreqFound, freq);
        }

        return maxFreqFound;
    }
}

// A B C (k = 2)
// start with each substring of length k + 1 and find distinct chars
// Then do with k + 2, 3, 4....
// Find max length

// AAABABB
// k = 1

// AAABABB, k = 1