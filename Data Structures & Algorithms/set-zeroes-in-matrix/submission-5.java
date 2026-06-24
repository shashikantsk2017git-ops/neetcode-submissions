class Solution {
    public void setZeroes(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    updateRowNCol(i, j, matrix);
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == -1) {
                   matrix[i][j] = 0;
                }
            }
        }
    }

    public void updateRowNCol(int row, int col, int[][] mat) {

        for(int i = 0; i < mat.length; i++) {
            if(mat[i][col] != 0)
                mat[i][col] = -1;
        }

        for(int i = 0; i < mat[row].length; i++) {
            if(mat[row][i] != 0)
                mat[row][i] = -1;
        }
    }
}
