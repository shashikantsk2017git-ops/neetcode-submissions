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
    public int minMeetingRooms(List<Interval> inter) {
        // inter.sort(Comparator.comparingInt(obj -> obj.start));
        // inter.sort((i1, i2) -> i1.start-i2.start);
        List<int[]> list = new LinkedList<>();
        for(int i = 0; i < inter.size(); i++) {
            list.add(new int[]{inter.get(i).start, 1});
            list.add(new int[]{inter.get(i).end, -1});
        }
        
        list.sort(Comparator.<int[]>comparingInt(obj -> obj[0]).thenComparingInt(obj -> obj[1]));
        int count = 0;
        int rooms = 0;

        for(int[] arr: list ) {
            count +=arr[1];
            rooms = Math.max(count, rooms);
        }
        return rooms;
    }
}
