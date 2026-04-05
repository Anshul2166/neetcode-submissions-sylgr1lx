"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        meeting_ongoing = 0
        list_meeting = []
        for interval in intervals:
            list_meeting.append((interval.start, 1))
            list_meeting.append((interval.end, -1))
        
        list_meeting = sorted(list_meeting, key = lambda t : t[0])

        for meeting in list_meeting:
            meeting_ongoing += meeting[1]
            if meeting_ongoing > 1:
                return False
        
        return True
