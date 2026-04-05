class KthLargest:

    heap = None
    k_num = None
    def __init__(self, k: int, nums: List[int]):
        self.heap = nums
        heapq.heapify(self.heap)
        self.k_num = k

    def add(self, val: int) -> int:
        heapq.heappush(self.heap, val)
        while len(self.heap) > self.k_num:
            heapq.heappop(self.heap)
        return self.heap[0]

        
