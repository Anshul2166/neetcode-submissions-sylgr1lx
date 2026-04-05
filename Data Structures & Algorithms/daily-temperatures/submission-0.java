class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] warm = new int[temperatures.length];

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i = temperatures.length - 1; i >= 0 ; i--){
            int currentTemp = temperatures[i];
            while(!stack.isEmpty() && stack.peek() <= currentTemp){
                stack.pop();
            }
            if(!stack.isEmpty()){
                warm[i] = map.get(stack.peek()) - i;
            }
            stack.push(currentTemp);
            map.put(currentTemp, i);
        }

        return warm;
    }
}
