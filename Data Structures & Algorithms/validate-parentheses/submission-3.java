class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '(' || curr == '[' || curr == '{'){
                stack.push(curr);
            }else{
                if(stack.isEmpty() ||  !checkIfCorrectParentheses(curr, stack.pop())){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean checkIfCorrectParentheses(char currBracket, char stackBracket){
        if(currBracket == ')' &&  stackBracket == '(')
            return true;
        else if(currBracket == ']' &&  stackBracket == '[')
            return true;
        else if(currBracket == '}' &&  stackBracket == '{')
            return true;
        return false;
    }
}
