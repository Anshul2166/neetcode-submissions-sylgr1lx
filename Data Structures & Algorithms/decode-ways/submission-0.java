class Solution {
    public int numDecodings(String s) {
        int[] decodings = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            int singleChar = Integer.valueOf(s.charAt(i)-'0');
            if(singleChar != 0)
                decodings[i] = (i > 0 ? decodings[i-1] : 1);

            if(i >= 1 && s.charAt(i-1) != '0'){
                int twoChars = Integer.valueOf(s.charAt(i-1)-'0')*10 + Integer.valueOf(s.charAt(i)-'0');
                if(twoChars <= 26){
                    decodings[i] += (i > 1 ? decodings[i-2] : 1);
                }
                System.out.println(twoChars);
            }
            System.out.println(decodings[i] + " "+singleChar);
        }
        return decodings[s.length() - 1];
    }
}
