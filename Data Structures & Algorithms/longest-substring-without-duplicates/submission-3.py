class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_len , left = 0, 0
        seen_till_now = set()

        for right, char in enumerate(s):
            while char in seen_till_now:
                seen_till_now.remove(s[left])
                left += 1
            seen_till_now.add(char)
            max_len = max(max_len, right - left + 1)
        
        return max_len
        