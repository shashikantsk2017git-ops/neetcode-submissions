class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, Comparator.<int[]>comparingInt(obj -> obj[0]).thenComparingInt(obj -> obj[1]));

        int ind = 0;
        arr[ind][0] = arr[0][0];
        arr[ind][1] = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= arr[ind][1]) {
                arr[ind][1] = Math.max(arr[ind][1], arr[i][1]);
            } else {
                ind++;
                arr[ind][0] = arr[i][0];
                arr[ind][1] = arr[i][1];
            }
        }
        return Arrays.copyOfRange(arr, 0, ind + 1);
    }
}
