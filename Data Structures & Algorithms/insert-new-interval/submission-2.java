class Solution {
    public int[][] insert(int[][] ar, int[] nin) {
        int i = 0;
        int n = ar.length;

        int[][] out = new int[ar.length+1][2];
        int ind = 0;
        //Add existing intervals in output until we are not getting new interval 
        //range in existing interval
        while(i < n && nin[0] > ar[i][1]) {
            out[ind][0] = ar[i][0];
            out[ind][1] = ar[i][1];
            ind++;
            i++;
        }

        //Once got new interval range in existing interval merge overlapping and 
        //at last add that interval
        while( i < n && nin[1] >= ar[i][0]) {
            nin[0] = Math.min(nin[0], ar[i][0]);
            nin[1] = Math.max(nin[1], ar[i][1]);
            i++;
        }
        out[ind][0] = nin[0];
        out[ind][1] = nin[1];
        ind++;

        //Add exiting intervals which are pending to be added in output
        while(i < n) {
            out[ind][0] = ar[i][0];
            out[ind][1] = ar[i][1];
            ind++;
            i++;
        }

        return Arrays.copyOfRange(out, 0, ind);
    }
}
