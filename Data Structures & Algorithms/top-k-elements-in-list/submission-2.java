class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // construct a map to keep track of frequency of each element
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num : nums){
            // merge to existing map
            freqMap.merge(num, 1, Integer::sum);
        }

        // create a priority queue that stores elements based on value
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry<Integer,Integer>::getValue).reversed()
        );

        // add to priority queue
        for(Map.Entry<Integer, Integer> mapEntry : freqMap.entrySet()){
            queue.add(mapEntry);
        }

        // top k frequent elements
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
