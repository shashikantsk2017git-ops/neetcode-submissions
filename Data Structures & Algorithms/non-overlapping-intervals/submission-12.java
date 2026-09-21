class Solution {
    public int eraseOverlapIntervals0(int[][] inter) {
        // Arrays.sort(in, (a , b) -> a[1] - b[1]);
        Arrays.sort(inter, Comparator.<int[]>comparingInt(obj -> obj[1]));

        int count = 1;
        int lastTime = inter[0][1];
        for(int i = 1; i < inter.length; i++) {
            if(inter[i][0] >= lastTime) {
                count++;
                lastTime = inter[i][1];
            }
        }
        return inter.length - count;
    }

    public int eraseOverlapIntervals(int[][] inter) {
        Arrays.sort(inter, Comparator.comparingInt(a -> a[0])); // sort by start

        int removed = 0;
        int lastEnd = inter[0][1];

        for (int i = 1; i < inter.length; i++) {
            if (inter[i][0] < lastEnd) {
                // overlap: remove the one with the larger end time
                removed++;
                lastEnd = Math.min(lastEnd, inter[i][1]);
            } else {
                lastEnd = inter[i][1];
            }
        }
        return removed;
    }
    
}

 