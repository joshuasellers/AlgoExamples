class Intervals:

    def __init__(self, intervals: list[list[int]]):
        self.intervals = intervals

    def canAttendMeetings(self) -> bool:
        self.intervals.sort(key=lambda interval: interval[0])
        for i in range(1, len(self.intervals)):
            if (self.intervals[i][0] < self.intervals[i-1][1]):
                return False
        return True
    
    '''
    Insert a new interval into a list of non-overlapping intervals and merge if necessary.

    Steps:
    1. Iterate through the existing intervals and compare them with the new interval.
    2. If the current interval overlaps with the new interval, merge them by updating the start and end times of the new interval.
    3. If the current interval does not overlap and is before the new interval, add it to the output list.
    4. If the current interval does not overlap and is after the new interval, add the new interval to the output list and then add the current interval.
    5. If the new interval has not been added by the end of the iteration, add it to the output list.

    Time Complexity: O(n) - We iterate through the list of intervals once.
    Space Complexity: O(n) - In the worst case, we might have to add all intervals to the output list.
    '''
    def insertIntervals(self, newInterval: list[int]):
        count = 0
        output = []
        inserted = False
        while count < len(self.intervals):
            interval = self.intervals[count]
            if interval[0] < newInterval[0] and interval[1] >= newInterval[0]:
                if interval[0] <= newInterval[0] and interval[1] >= newInterval[1]:
                    output.append(interval)
                    inserted = True
                    output.extend(self.intervals[count+1:])  # add remaining intervals
                    break
                newInterval[0] = interval[0]
            elif interval[0] <= newInterval[1] and interval[1] > newInterval[1]:
                if interval[0] <= newInterval[0] and interval[1] >= newInterval[1]:
                    output.append(interval)
                    inserted = True
                    output.extend(self.intervals[count+1:])  # add remaining intervals
                    break
                newInterval[1] = interval[1]
            elif interval[0] >= newInterval[0] and interval[1] <= newInterval[1]:
                pass
            elif interval[0] > newInterval[1]:
                output.append(newInterval)
                inserted = True
                output.append(interval)
                output.extend(self.intervals[count+1:])  # add remaining intervals
                break
            else:
                output.append(interval)
            count += 1
        if not inserted:
            output.append(newInterval)
        return output