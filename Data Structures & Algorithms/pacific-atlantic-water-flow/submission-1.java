class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowLen = heights.length;
        int colLen = heights[0].length;

        boolean[][] pacWay = new boolean[rowLen][colLen];
        boolean[][] atlWay = new boolean[rowLen][colLen];

        List<List<Integer>> out = new ArrayList<>();

        for(int i = 0; i < rowLen; i++) {
            check(heights, pacWay, i, 0, -1, -1);
            check(heights, atlWay, i, colLen-1, -1, -1);
        }

        for(int j = 0; j < colLen; j++) {
            check(heights, pacWay, 0, j, -1, -1);
            check(heights, atlWay, rowLen - 1, j, -1, -1);
        }

        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                if(pacWay[i][j] && atlWay[i][j]) {
                    List<Integer> found = new ArrayList<>();
                    found.add(i);
                    found.add(j);
                    out.add(found);
                }
            }
        }
        return out;
    }


    public void check(int[][] heights, boolean[][] vis, int row, int col, int orow, int ocol) {

        if(row <0 || col <0 || row > heights.length-1 || col > heights[row].length-1 || vis[row][col]
            || (orow >=0 && ocol >=0 && heights[orow][ocol] > heights[row][col])) return;

        vis[row][col] = true;
        check(heights, vis, row+1, col, row, col);
        check(heights, vis, row-1, col, row, col);
        check(heights, vis, row, col+1, row, col);
        check(heights, vis, row, col-1, row, col);
    }
}