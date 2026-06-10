class Solution {
    public int[][] insert(int[][] arr, int[] narr) {
        int[][] out = new int[arr.length+1][2];

        int i = 0;
        int end = arr.length;

        int index = 0;
        while(i < end && arr[i][1] < narr[0]) {
            out[index][0] = arr[i][0];
            out[index][1] = arr[i][1];
            index++;
            i++;
        }

        while(i < end && arr[i][0] <= narr[1]) {
            narr[0] = Math.min(narr[0], arr[i][0]);
            narr[1] = Math.max(narr[1], arr[i][1]);
            i++;
        }
        out[index][0] = narr[0];
        out[index][1] = narr[1];
        index++;

        while(i < end) {
            out[index][0] = arr[i][0];
            out[index][1] = arr[i][1];
            index++;
            i++;
        }

        return Arrays.copyOfRange(out, 0, index);
    }
}