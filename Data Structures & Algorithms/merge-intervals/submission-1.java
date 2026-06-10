class Solution {
    public int[][] merge(int[][] arr) {
        int n = arr.length;
        int[][] out = new int[n][2];
        int index = 0;

        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);

        int startIn = arr[0][0];
        int endIn = arr[0][1];

        out[index][0] = startIn;
        out[index][1] = endIn;

        for(int i = 1; i < n; i++) {
            if(arr[i][0] <= endIn) {
                endIn = Math.max(endIn, arr[i][1]);
            } else {
                index++;
                startIn = arr[i][0];
                endIn = arr[i][1];
            }
            out[index][0] = startIn;
            out[index][1] = endIn;
        }

        return Arrays.copyOfRange(out, 0, index+1);
    }
}