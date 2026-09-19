/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        intervals.sort(Comparator.comparingInt(obj -> obj.start));
        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start < intervals.get(i-1).end) return false;
        }
        return true;
    }
}
