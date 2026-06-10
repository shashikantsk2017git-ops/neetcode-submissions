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
            list.add(new int[]{in.start, 1}); //Add 1 to check meeting start time
            list.add(new int[]{in.end, -1}); //Add -1 to check meeting ends time
        }

        //sor list by start time if matches then end time

        list.sort((l1, l2) -> l1[0] != l2[0] ? l1[0]-l2[0]: l1[1]-l2[1]);

        int count = 0;
        int rooms = 0;

        for(int[] arr: list) {
            count += arr[1]; //count it will increase if meeting has +1 and decrease if meeting
            //ends means has -1, -1 means meeting finished room is free
            rooms = Math.max(rooms, count);
        }
        return rooms;
    }
}