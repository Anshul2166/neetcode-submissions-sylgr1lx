class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone : stones){
            queue.add(stone);
        }
        while(!queue.isEmpty()){
            int largestStone = queue.poll();
            if(queue.size() == 0){
                return largestStone;
            }
            int secondLargestStone = queue.poll();
            if(largestStone - secondLargestStone > 0)
                queue.add(largestStone - secondLargestStone);
        }
        return 0;
    }
}
