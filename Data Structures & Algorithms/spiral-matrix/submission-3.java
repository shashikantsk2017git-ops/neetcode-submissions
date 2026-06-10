class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int rowl = 0;
        int rowm = matrix.length-1;

        int coll = 0;
        int colm = matrix[0].length-1;

        while(rowl <= rowm && coll <= colm) {
            for(int i = coll; i <= colm; i++) {
                res.add(matrix[rowl][i]);
            }
            rowl++;

            for(int i = rowl; i <= rowm;i++) {
                res.add(matrix[i][colm]);
            }
            colm--;
            if(rowl > rowm) break;
            for(int i = colm; i >= coll; i--) {
                res.add(matrix[rowm][i]);
            }
            rowm--;
            if(coll > colm) break;
            for(int i = rowm; i >= rowl; i--) {
                res.add(matrix[i][coll]);
            }
            coll++;
        }

        return res;
    }
}
