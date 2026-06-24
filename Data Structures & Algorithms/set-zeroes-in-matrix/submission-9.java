class Solution {

    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) firstColZero = true;
        }

        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) firstRowZero = true;
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j=1; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRowZero) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if(firstColZero) {  
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes0(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
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
