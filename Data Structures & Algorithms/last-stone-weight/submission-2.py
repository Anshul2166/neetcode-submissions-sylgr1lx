class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int: 
        heap = stones
        heap = [-x for x in heap]
        heapq.heapify(heap)

        while len(heap) > 1:
            first = heapq.heappop(heap)
            second = heapq.heappop(heap)
            if first != second:
                heapq.heappush(heap, first - second)
        
        return -1 * heap[0] if len(heap) == 1 else 0

        