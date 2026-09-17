class Solution {
    public void setZeroes(int[][] mat) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for(int i = 0; i < mat.length; i++) {
            if(mat[i][0] == 0) firstColZero = true;
        }

        for(int i = 0; i < mat[0].length; i++) {
            if(mat[0][i] == 0) firstRowZero = true;
        }

        for(int i = 1; i < mat.length; i++) {
            for(int j = 1; j < mat[i].length; j++) {
                if(mat[i][j] == 0) {
                    mat[0][j] = 0;
                    mat[i][0] = 0;
                } 
            }
        }

        for(int i = 1; i < mat.length; i++) {
            for(int j = 1; j < mat[i].length; j++) {
                if(mat[i][0] == 0 || mat[0][j] == 0) {
                   mat[i][j] = 0;
                } 
            }
        }

        if(firstRowZero) {
            for(int i = 0; i < mat[0].length; i++) {
                mat[0][i] = 0;
            }
        }
        if(firstColZero) {
            for(int i = 0; i < mat.length; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
