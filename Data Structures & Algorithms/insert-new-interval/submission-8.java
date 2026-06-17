class Solution {
    public int[][] insert(int[][] arr, int[] narr) {
        int[][] out = new int[arr.length+1][2];
        int ind = 0;

        int i = 0;
        int last = 0;
        while(i < arr.length && arr[i][1] < narr[0]) {
            out[ind][0] = arr[i][0];
            out[ind][1] = arr[i][1];
            ind++;
            i++;
        }

        while(i < arr.length && narr[1] >= arr[i][0]) {
            narr[0] = Math.min(arr[i][0], narr[0]);
            narr[1] = Math.max(arr[i][1], narr[1]);
            i++;
        }

        out[ind][0] = narr[0];
        out[ind][1] = narr[1];
        ind++;

        while(i < arr.length) {
            out[ind][0] = arr[i][0];
            out[ind][1] = arr[i][1];
            ind++;
            i++;
        }

        return Arrays.copyOfRange(out, 0, ind);
    }
    
}