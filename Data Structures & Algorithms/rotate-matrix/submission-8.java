class Solution {

    //First reversing each row then transposing, 
    //Transpose along the anti-diagonal instead of the main diagonal
    public void rotate0(int[][] mat) {
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
             for(int j = 0; j < n - i; j++) {
                //if(i + j < n) { this can be written as j < n - i
                int temp = mat[i][j];
                mat[i][j] = mat[n-j][n-i];
                mat[n-j][n-i] = temp;
                //}
            }
        }
    }

    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        //Transpose -> convert row into coloumn (but touch only cell that is not touched earlier)
        for(int i = 0; i < row; i++) {
            for(int j = i + 1; j < col; j++) {  
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse
        for(int i = 0; i < row; i++) {
            int l = 0; int r = col-1;
            while(l < r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}
