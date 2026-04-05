class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded_str = ""
        for str1 in strs:
            len_str = str(len(str1)).zfill(4)
            encoded_str += len_str + "#" + str1
        print(encoded_str)
        return encoded_str

    def decode(self, s: str) -> List[str]:
        index = 0
        decoded_str = []
        while index < len(s):
            len_str = int(s[index : index + 4])
            index = index + 3 + 1 + 1 # skip # char
            decoded_str.append(s[index : index + len_str])
            index = index + len_str
        return decoded_str
