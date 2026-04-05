class KthLargest:

    heap = []
    max_elements = -1

    def __init__(self, k: int, nums: List[int]):
        self.heap = nums
        self.max_elements = k

        heapq.heapify(self.heap)
        
        while len(self.heap) > self.max_elements:
            heapq.heappop(self.heap)
        

    def add(self, val: int) -> int:
        heapq.heappush(self.heap, val)
        
        if len(self.heap) > self.max_elements:
            heapq.heappop(self.heap)
        
        return self.heap[0]
