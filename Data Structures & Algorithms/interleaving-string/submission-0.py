class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:

        n = len(s3)

        from functools import cache
        
        @cache
        def interleave(s1Index : int, s2Index : int) -> bool:
            s3Index = s1Index + s2Index
            if s3Index == n:
                return True
            
            if s1Index >= len(s1) and s2Index >= len(s2):
                return False
            
            if s1Index < len(s1) and s1[s1Index] == s3[s3Index]:
                if interleave(s1Index + 1, s2Index):
                    return True
            if s2Index < len(s2) and s2[s2Index] == s3[s3Index]:
                if interleave(s1Index, s2Index + 1):
                    return True
            
            return False

        if (len(s1) + len(s2)) != n:
            return False
        
        return interleave(0, 0)
        