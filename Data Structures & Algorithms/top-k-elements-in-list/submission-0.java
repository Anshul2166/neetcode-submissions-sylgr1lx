class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.merge(num, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            queue.add(entry);
            while(queue.size() > k){
                queue.poll();
            }
        }
        return queue.stream()
        .mapToInt(Map.Entry::getKey)
        .toArray();
    }
}
