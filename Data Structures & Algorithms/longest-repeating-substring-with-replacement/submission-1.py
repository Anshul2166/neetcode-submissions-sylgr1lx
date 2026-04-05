class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        left, right = 0, k + 1
        freq_counter = self.getFreqCounter(s[left : right])
        max_len = 0

        while right < len(s):
            freq_counter[ord(s[right]) - ord('A')] += 1

            while (right - left + 1) - max(freq_counter) > k:
                freq_counter[ord(s[left]) - ord('A')] -= 1
                left += 1
            max_len = max(max_len, right - left + 1)
            right += 1 
        
        return max_len
    
    def getFreqCounter(self, s: str) -> List[int]:
        freq_counter = [0] * 26
        for char in s:
            freq_counter[ord(char) - ord('A')] += 1
        return freq_counter


            
        
