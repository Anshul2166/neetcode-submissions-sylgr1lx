class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // freqString -> list of words with that freq string
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            String freqString = getFreqString(str);
            // map.merge(freqString, str, ArrayList::add);
            if(map.containsKey(freqString)){
                // add to the existing list mapped to freqString
                map.get(freqString).add(str);
            }else{
                // create new list and add that string to it
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(freqString, newList);
            }
        }

        return new ArrayList<>(map.values());
    }

    public String getFreqString(String str){
        //construct freq Arr
        int[] freqArr = new int[26];

        // Update the array with each value
        for(int i = 0; i < str.length(); i++){
            freqArr[str.charAt(i) - 'a']++;
        }

        // construct freq string
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(freqArr[i] != 0){
                sb.append((char)('a' + i));
                sb.append('-');
                sb.append(freqArr[i]);
            }
        }

        return sb.toString();
    }
}
