class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for(int i = 0; i < s.length(); i++){
            char chr = s.charAt(i);
            if(chr == '{' || chr == '[' || chr == '('){
                stack.push(chr);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char lastChar = stack.pop();
                if(!areSameBrackets(chr, lastChar))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean areSameBrackets(char chr, char lastChar){
        if(chr == ')' && lastChar == '('){
            return true;
        }else if(chr == ']' && lastChar == '['){
            return true;
        }else if(chr == '}' && lastChar == '{'){
            return true;
        }
        return false;
    }
}
