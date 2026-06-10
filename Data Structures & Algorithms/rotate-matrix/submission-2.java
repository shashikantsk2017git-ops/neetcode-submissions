class Solution {
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
