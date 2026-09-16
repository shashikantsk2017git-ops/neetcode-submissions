class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length-1;
        for(int i = 0; i <= n; i++) {
            int l = 0;
            int r = mat[i].length-1;
            while(l < r) {
                int tmp = mat[i][l];
                mat[i][l] = mat[i][r];
                mat[i][r] = tmp;
                l++;
                r--;
            }
        }

        for(int i = 0; i <= n; i++) {
            // for(int j = 0; j <= n; j++) {
            //     if(i + j < n) {
             for(int j = 0; j < n - i; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[n-j][n-i];
                    mat[n-j][n-i] = temp;
            }
        }
    }
}
