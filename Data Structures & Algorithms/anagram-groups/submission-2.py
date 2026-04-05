class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dict_anagram = defaultdict(list)
        for str in strs:
            sorted_key = ''.join(sorted(str))
            dict_anagram[sorted_key].append(str)
        
        return list(dict_anagram.values())
        