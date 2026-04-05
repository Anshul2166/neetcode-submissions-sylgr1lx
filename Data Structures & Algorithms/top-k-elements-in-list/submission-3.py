class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        c = Counter(nums)
        
        # Return a list of tuples with (element, freq)
        return [elem for elem, freq in c.most_common(k)]
        