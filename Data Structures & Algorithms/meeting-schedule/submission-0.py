"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        meeting = defaultdict(int)

        for interval in intervals:
            meeting[interval.start] += 1
            meeting[interval.end] -= 1

        meeting = {k : v for k, v in sorted(meeting.items(), key = lambda t : t[0])}

        meeting_count = 0

        for k, v in meeting.items():
            meeting_count = meeting_count + meeting[k]
            if meeting_count > 1:
                return False
        
        return True
        

