class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas) # length of route

        # start from end of route
        start, end = n - 1, n - 1
        
        stations_found = 0

        current_gas = 0

        # Keep looping till we find a station
        while stations_found != n:
            potential_current_gas = current_gas + gas[end] - cost[end]
            if current_gas >= 0:
                end = (end + 1) % n
                current_gas = potential_current_gas
            else:
                start = start - 1
                current_gas = current_gas + gas[start] - cost[start]
            stations_found += 1

        if current_gas >= 0:
            return start
        else:
            return -1
         
        