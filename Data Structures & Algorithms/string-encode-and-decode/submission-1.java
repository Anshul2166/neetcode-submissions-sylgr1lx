class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedSb = new StringBuilder();
        for(String str : strs){
            int len = str.length();
            if(len == 0){
                encodedSb.append("000");
            }else{
                if(len < 10)
                    encodedSb.append("00");
                else if(len < 100)
                    encodedSb.append("0");
                encodedSb.append(len);
                encodedSb.append(str);
            }
        }
        return encodedSb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<String>();
        System.out.println(str);
        int index = 0;
        while(index < str.length()){
            int lengthOfStr = Integer.valueOf(str.substring(index, index + 3));
            index = index + 3;
            if(lengthOfStr == 0){
                list.add("");
            }else{
                String curr = str.substring(index, index + lengthOfStr);
                index = index + lengthOfStr;
                list.add(curr);
            }
        }
        return list;
    }
}
