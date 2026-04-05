class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        hand = sorted(hand)

        count = {}

        for num in hand:
            if num in count:
                count[num] += 1
            else:
                count[num] = 1
        
        for num in hand:
            if count[num] == 0:
                # already scanned the record
                # skip it
                continue
            
            # this will be smallest element in group
            count[num] -= 1

            # For next groupSize - 1 elements, check if they exist
            # If yes, then reduce count
            # Else return False
            for i in range(1, groupSize) :
                if (num + i) in count and count[num + i] > 0:
                    count[num + i] -= 1
                else:
                    return False

        # If we reach end, then grouping is possible
        return True


        