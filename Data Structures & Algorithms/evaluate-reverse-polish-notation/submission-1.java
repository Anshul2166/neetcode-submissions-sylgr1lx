class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens){
            if(isOperator(token)){
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operate(operand1,operand2,token));
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    boolean isOperator(String token){
        if(token.length()== 1){
            char chr = token.charAt(0);
            if(chr == '+' || chr == '-' || chr == '*' || chr == '/')
                return true;
        }
        return false;
    }

    int operate(int a1, int a2, String token){
        char chr = token.charAt(0);
        if(chr == '+')
            return a1 + a2;
        else if(chr == '-')
            return a1 - a2;
        else if(chr == '*')
            return a1*a2;
        else
            return a1/a2;
    }
}
