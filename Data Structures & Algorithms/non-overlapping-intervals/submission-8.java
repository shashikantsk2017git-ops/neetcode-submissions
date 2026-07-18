class Solution {
    public int eraseOverlapIntervals(int[][] in) {
        Arrays.sort(in, (a , b) -> a[1] - b[1]);

        int lastTime = in[0][1];
        int count = 1;
        for(int i = 0; i < in.length; i++) {
            if(in[i][0] >= lastTime) {
                count++;
                lastTime = in[i][1];
            }
        }
        return in.length - count;
    }
    
}

 