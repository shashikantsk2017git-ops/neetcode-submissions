class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> out = new LinkedList<>();

        int rmin = 0;
        int rmax = matrix.length-1;
        
        int cmin = 0;
        int cmax = matrix[0].length-1;

        while( rmax >= rmin && cmax >= cmin ) {
            for(int i = cmin; i <= cmax; i++) {
                out.add(matrix[rmin][i]);
            }
            rmin++;
            for(int i = rmin; i <= rmax; i++) {
                out.add(matrix[i][cmax]);
            }
            cmax--;
            if (rmin <= rmax) {
                for(int i = cmax; i>=cmin; i--) {
                    out.add(matrix[rmax][i]);
                }
                rmax--;
            }
            if(cmin <= cmax) {
                for(int i = rmax; i>=rmin; i--) {
                    out.add(matrix[i][cmin]);
                }
                cmin++;
            }
        }

        return out;
    }
}
