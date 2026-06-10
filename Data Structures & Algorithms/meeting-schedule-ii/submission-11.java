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
    // public int minMeetingRooms1(List<Interval> intervals) {
    //     Collections.sort(intervals, (a, b) -> a.end != b.end ? a.end - b.end : a.start - b.start);

    //     int count = 0;
    //     if(intervals.size() == 0) {
    //         return count;
    //     }
    //     count++;
    //     int prevEnd = intervals.get(0).end;
    //     for(int i = 0; i < intervals.size(); i++) {
    //         if(intervals.get(i).start >= prevEnd) {
    //             count++;
    //             prevEnd = intervals.get(i).end;
    //         }
    //     }
    //     return count;
    //     // List<int[]> list = new ArrayList<>();

    //     // for(Interval in: intervals) {
    //     //     list.add(new int[]{in.start, 1}); //Add 1 to check meeting start time
    //     //     list.add(new int[]{in.end, -1}); //Add -1 to check meeting ends time
    //     // }

    //     // //sor list by start time if matches then end time

    //     // list.sort((l1, l2) -> l1[0] != l2[0] ? l1[0]-l2[0]: l1[1]-l2[1]);

    //     // int count = 0;
    //     // int rooms = 0;

    //     // for(int[] arr: list) {
    //     //     count += arr[1]; //count it will increase if meeting has +1 and decrease if meeting
    //     //     //ends means has -1, -1 means meeting finished room is free
    //     //     rooms = Math.max(rooms, count);
    //     // }
    //     // return rooms;
    // }


    public int minMeetingRooms(List<Interval> intervals) {
        // Fix: sort by start time, not end time
        Collections.sort(intervals, (a, b) -> a.start != b.start ? a.start - b.start : a.end - b.end);

        int count = 0;
        if(intervals.size() == 0) {
            return count;
        }
        count++;
        List<Integer> roomEnds = new ArrayList<>();
        roomEnds.add(intervals.get(0).end);

        for(int i = 1; i < intervals.size(); i++) {
            int earliestEnd = Integer.MAX_VALUE;
            int earliestIdx = -1;
            for(int j = 0; j < roomEnds.size(); j++) {
                if(intervals.get(i).start >= roomEnds.get(j) && roomEnds.get(j) < earliestEnd) {
                    earliestEnd = roomEnds.get(j);
                    earliestIdx = j;
                }
            }
            if(earliestIdx != -1) {
                roomEnds.set(earliestIdx, intervals.get(i).end);
            } else {
                count++;
                roomEnds.add(intervals.get(i).end);
            }
        }
        return count;
    }
}