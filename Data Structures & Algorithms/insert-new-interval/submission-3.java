class Solution {
    public int[][] insert(int[][] arr, int[] narr) {
        int n = arr.length;
        int[][] out = new int[n+1][2];
        int index = 0;
        int i = 0;
        //left part where new interval is not fallling
        while(i < n && arr[i][1] < narr[0] ) {
            out[index][0] = arr[i][0];
            out[index][1] = arr[i][1];
            index++;
            i++;
        }

        //part where interval falling check for overlapping

        while(i < n && arr[i][0] <= narr[1]) {
            narr[0] = Math.min(arr[i][0], narr[0]);
            narr[1] = Math.max(arr[i][1], narr[1]);
            i++;
        }
        out[index][0] = narr[0];
        out[index][1] = narr[1];
        index++;

        //Right part where new intervals in not falling
        while(i < n) {
            out[index][0] = arr[i][0];
            out[index][1] = arr[i][1];
            index++;
            i++;
        }

        return Arrays.copyOfRange(out, 0, index);
    }
}