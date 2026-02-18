class Intervals:

    def __init__(self, intervals: list[list[int]]):
        self.intervals = intervals

    def canAttendMeetings(self) -> bool:
        self.intervals.sort(key=lambda interval: interval[0])
        for i in range(1, len(self.intervals)):
            if (self.intervals[i][0] < self.intervals[i-1][1]):
                return False
        return True