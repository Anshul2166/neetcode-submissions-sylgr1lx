class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int[] charFreqS = getFreqArray(s);
        int[] charFreqT = getFreqArray(t);

        return isEqualArr(charFreqS, charFreqT);
    }

    public int[] getFreqArray(String str){
        int[] freqArr = new int[26];

        for(int i = 0; i < str.length(); i++){
            freqArr[str.charAt(i) - 'a']++;    
        }

        return freqArr;
    }

    public boolean isEqualArr(int[] arr1, int[] arr2){
        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
