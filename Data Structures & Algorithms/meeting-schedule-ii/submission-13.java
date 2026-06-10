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
       
        List<int[]> list = new ArrayList<>();

        for(Interval in: intervals) {
            list.add(new int[]{in.start, 1});
            list.add(new int[]{in.end, -1});
        }

        list.sort((a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        int count = 0;
        int rooms = 0;
        for(int[] ar: list) {
            count += ar[1];
            rooms = Math.max(rooms, count);
        }

        return rooms;
    }
}