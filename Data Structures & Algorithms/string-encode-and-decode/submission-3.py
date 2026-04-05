class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded_str = ""
        for str1 in strs:
            encoded_str += str(len(str1)) + "#" + str1
        return encoded_str

    def decode(self, s: str) -> List[str]:
        index = 0
        decoded_str = []
        while index < len(s):
            len_str = 0
            while s[index] != '#':
                len_str  = 10*len_str + (int)(s[index])
                index += 1
            index += 1 # skip # char
            decoded_str.append(s[index : index + len_str])
            index = index + len_str
        return decoded_str
