class Solution {
    public void setZeroes(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    updateRowNCol(matrix, i, j);
                }
            }
        }

        updateToZero(matrix);
    }

    public void updateRowNCol(int[][] matrix, int row, int col) {
        for(int i = 0; i < matrix[row].length; i++) {
            if(matrix[row][i] != 0)
                matrix[row][i] = -1;
        }

        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][col] != 0)
                matrix[i][col] = -1;
        }
    }

    public void updateToZero(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
