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
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> meetings = new ArrayList<>();

        for(Interval inte: intervals) {
            meetings.add(new int[]{inte.start, 1});
            meetings.add(new int[]{inte.end, -1});
        }

        meetings.sort(Comparator.<int[]>comparingInt(obj -> obj[0]).thenComparingInt(obj -> obj[1]));

        int count = 0;
        int rooms = 0;
        for(int[] meeting: meetings) {
            count += meeting[1];
            rooms = Math.max(rooms, count);
        }

        return rooms;
    }
}
