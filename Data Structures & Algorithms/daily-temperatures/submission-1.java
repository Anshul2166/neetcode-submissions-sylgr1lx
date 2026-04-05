class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] hottest = new int[temperatures.length];
        
        Deque<Integer> stack = new ArrayDeque<Integer>();

        Map<Integer, Integer> tempToIndexMap = new HashMap<>();

        for(int i = temperatures.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= temperatures[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                hottest[i] = 0;
            }else{
                hottest[i] = tempToIndexMap.get(stack.peek()) - i;
            }
            
            tempToIndexMap.put(temperatures[i], i);

            stack.push(temperatures[i]);
        }

        return hottest;
    }
}
