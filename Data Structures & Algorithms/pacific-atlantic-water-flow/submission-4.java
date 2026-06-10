class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] hi) {
        boolean[][] pvis = new boolean[hi.length][hi[0].length];
        boolean[][] avis = new boolean[hi.length][hi[0].length];

        List<List<Integer>> out = new ArrayList<>();
        for(int i = 0; i < hi.length; i++) {
            check(hi, pvis, i, 0, -1, -1);
            check(hi, avis, i, hi[0].length-1, -1, -1);
        }

        for(int i = 0; i < hi[0].length; i++) {
            check(hi, pvis, 0, i, -1, -1);
            check(hi, avis, hi.length-1, i, -1, -1);
        }

        for(int i = 0; i < hi.length; i++) {
            for(int j=0; j< hi[i].length; j++) {
                if(pvis[i][j] && avis[i][j]) {
                    List<Integer> found = new ArrayList<>();
                    found.add(i);
                    found.add(j);
                    out.add(found);
                }
            }
        }
        return out;
    }

    public void check(int[][] hi, boolean[][] vis, int row, int col, int prevRow, int prevCol) {

        if(row > hi.length-1 || row < 0 || col > hi[row].length-1 || col < 0 || vis[row][col]
            || (prevRow >=0 && prevCol >=0 && hi[row][col] < hi[prevRow][prevCol])
        ) return;

        vis[row][col] = true;
        check(hi, vis, row+1, col, row, col);
        check(hi, vis, row-1, col, row, col);
        check(hi, vis, row, col+1, row, col);
        check(hi, vis, row, col-1, row, col);
    }
}