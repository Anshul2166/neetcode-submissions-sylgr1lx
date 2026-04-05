class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = 0
        right = 0
        max_len = 0
        seen_till_now = set()

        while right < len(s):
            while s[right] in seen_till_now:
                seen_till_now.remove(s[left])
                left += 1
            seen_till_now.add(s[right])
            max_len = max(max_len, right - left + 1)
            right += 1
        
        return max_len
        