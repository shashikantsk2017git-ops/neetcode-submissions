class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pv = new boolean[heights.length][heights[0].length];
        boolean[][] av = new boolean[heights.length][heights[0].length];

        List<List<Integer>> out = new LinkedList<>();

        for(int i = 0; i < heights.length; i++) {
            check(heights, pv, i, 0, -1, -1);
            check(heights, av, i, heights[0].length-1, -1, -1);
        }

        for(int i = 0; i < heights[0].length; i++) {
            check(heights, pv, 0, i, -1, -1);
            check(heights, av, heights.length-1, i, -1, -1);
        }

        for(int i = 0; i < heights.length; i++ ) {
            for(int j = 0; j < heights[i].length; j++) {
                if(pv[i][j] && av[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    out.add(temp);
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