class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // act - "a1-c1-t1"
        // atcb - "a1-b1-c1-t1"
        // bact - "a1-b1-c1-t1"

        // Map freq string to list of string who have that freqString
        Map<String, List<String>> freqStringToStrMap = new HashMap<>();

        for(String str : strs){
            String frequencyString = constructFrequencyString(str);
            if(freqStringToStrMap.containsKey(frequencyString)){
                // if key already exists
                freqStringToStrMap.get(frequencyString).add(str);
            }else{
                // key doesn't exist
                List<String> list = new ArrayList<String>();
                list.add(str);
                freqStringToStrMap.put(frequencyString, list);
            }
        }

        return new ArrayList<List<String>>(freqStringToStrMap.values());
    }

    public String constructFrequencyString(String str){
        // since we have lower case English alphabets only
        int[] arr = new int[26];

        // 'c'-'a' = 2 -> arr[2] = how many c are there?
        char[] charArray = str.toCharArray();
        for(char chr : charArray){
            arr[chr-'a']++;
        }

        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < arr.length; i++){
            if(arr[i]!=0){
                sb.append((char)('a' + i));
                sb.append(arr[i]);
                sb.append("-");
            }
        }

        return sb.toString();
    }
}
