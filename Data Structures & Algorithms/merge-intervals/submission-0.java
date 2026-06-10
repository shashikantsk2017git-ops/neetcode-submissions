class Solution {
    public int[][] merge(int[][] arr) {
        int[][] out = new int[arr.length][2];

        // Arrays.sort(arr, (arr1, arr2) -> { 
        //     return arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr1[0] - arr2[0]; 
        // });

        Arrays.sort(arr, (arr1, arr2) -> arr1[0] == arr2[0] ? arr1[1] - arr2[1] : arr1[0] - arr2[0]);

        int start = arr[0][0];
        int end = arr[0][1];

        int index = 0;
        for(int i=1; i < arr.length; i++) {
            if(arr[i][0]<=end) {
                end = Math.max(end, arr[i][1]);
            } else {
                out[index][0] = start;
                out[index][1] = end;

                start = arr[i][0];
                end = arr[i][1];
                index++;
            }
        }
        out[index][0] = start;
        out[index][1] = end;
        return Arrays.copyOfRange(out, 0, index+1);
    }
}