class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1FreqArr = new int[26];
        int[] currFreqArr = new int[26];

        if(s2.length() < s1.length())
            return false;

        for(int i = 0; i < s1.length(); i++){
            s1FreqArr[s1.charAt(i)-'a']++;
            currFreqArr[s2.charAt(i)-'a']++;
        }

        if(checkSameArr(s1FreqArr, currFreqArr)){
            return true;
        }

        for(int right = s1.length(); right < s2.length(); right++){
            currFreqArr[s2.charAt(right - s1.length())-'a']--;
            currFreqArr[s2.charAt(right)-'a']++;
            if(checkSameArr(s1FreqArr, currFreqArr)){
                return true;
            }
        }
        return false;
    }

    public boolean checkSameArr(int[] a1, int[] a2){
        for(int i = 0; i < 26; i++){
            if(a1[i]!=a2[i]){
                return false;
            }
        }
        return true;
    }
}
