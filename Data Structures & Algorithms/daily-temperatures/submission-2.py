class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        result = [0] * len(temperatures)

        for i in range(len(temperatures) - 1, -1, -1):
            curr_temp = temperatures[i]

            # Keep removing elements from stack if stack is non-empty and we are seeing temperatures lower or equal to currrent temperature
            while len(stack) > 0 and temperatures[stack[-1]] <= curr_temp:
                stack.pop()
            
            # Found a temperature greater than current temperature
            if len(stack) > 0:
                result[i] = stack[-1] - i
            
            stack.append(i)

        return result