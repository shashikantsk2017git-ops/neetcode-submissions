class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> out = new ArrayList<>();
        int minr = 0;
        int maxr = matrix.length-1;

        int minc = 0;
        int maxc = matrix[0].length-1;

        while(minr <= maxr && minc <= maxc) {

            for(int i = minc; i <= maxc; i++) out.add(matrix[minr][i]);
            minr++;

            for(int i = minr; i <= maxr; i++) out.add(matrix[i][maxc]);
            maxc--;
            if(minr > maxr) break;
            for(int i = maxc; i >= minc; i--) out.add(matrix[maxr][i]);
            maxr--;

            if(minc > maxc) break;
            for(int i = maxr; i >= minr; i--) out.add(matrix[i][minc]);
            minc++;
        }

        return out;
    }
}
