class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }
    
    // 2 3 4 5 6
    // 5 4 3 2 1

    // 5#Hello5#World

    public List<String> decode(String str) {
        int index = 0;
        List<String> result = new ArrayList<>();

        while(index < str.length()){
            int length = 0;
            while(str.charAt(index) != '#'){
                length = length * 10 + (int)(str.charAt(index) - '0');
                index++;
            }
            index++; // skip #
            StringBuilder currStr = new StringBuilder();
            
            while(length > 0){
                currStr.append(str.charAt(index));
                index++;
                length--;
            }
            result.add(currStr.toString());
        }

        return result;
    }
}
