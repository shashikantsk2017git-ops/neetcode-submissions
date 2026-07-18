class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        int ind = 0;
        arr[ind][0] = arr[0][0];
        arr[ind][1] = arr[0][1];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i][0] <= arr[ind][1]) {
                arr[ind][1] = Math.max(arr[ind][1], arr[i][1]);
            } else {
                ind++;
                arr[ind][0] = arr[i][0];
                arr[ind][1] = arr[i][1];
            }
        }
        return Arrays.copyOfRange(arr, 0, ind+1);
    }

    public int[][] merge1(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        int sT = arr[0][0];
        int lT = arr[0][1];
        int ind = 0;
        arr[ind][0] = sT;
        arr[ind][1] = lT;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i][0] <= arr[i-1][1]) {
                lT = Math.max(arr[i][1], arr[i-1][1]);
                arr[ind][1] = lT;
            } else {
                ind++;
                arr[ind][0] = arr[i][0];
                arr[ind][1] = arr[i][1];
            }
        }
        return Arrays.copyOfRange(arr, 0, ind+1);
    }

}

