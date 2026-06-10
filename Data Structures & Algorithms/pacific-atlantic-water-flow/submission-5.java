class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] hi) {
        //output which will have answer
        List<List<Integer>> out = new ArrayList<>();

        //create visited array for both ocean
        boolean[][] pacific = new boolean[hi.length][hi[0].length];
        boolean[][] atlantic = new boolean[hi.length][hi[0].length];

        //Start visiting in all four direction to mark if path possible or not
        //left -> pacific, right -> atlantic
        for(int i = 0; i < hi.length; i++) {
            //left
            checkNmark(hi, pacific, i, 0, -1, -1); // when starting we don't have any previous row or col
            //right
            checkNmark(hi, atlantic, i, hi[i].length-1, -1, -1);
        }

        //top -> pacific, bottom -> atlantic
        for(int i = 0; i < hi[0].length; i++) {
            //up
            checkNmark(hi, pacific, 0, i, -1, -1);
            //bottom
            checkNmark(hi, atlantic, hi.length-1, i, -1, -1);
        }

        //Now check both pacific and atlantic visited matrix for any row and col if both true means possible
        for(int i = 0; i < hi.length; i++) {
            for(int j = 0 ; j < hi[i].length; j++) {
                //if both matrix has true means water can flow in both ocean
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> found = new ArrayList<>();
                    found.add(i);
                    found.add(j);
                    out.add(found);
                }
            }
        }
        return out;
    }

    public void checkNmark(int[][] hi, boolean[][] vis, int row, int col, int preRow, int preCol) {
        //negitive possibilities return
        if(row < 0 || col < 0 || row > hi.length-1 || col > hi[row].length-1 || vis[row][col]
            || (preRow >=0 && preCol >=0 && hi[row][col] < hi[preRow][preCol])
        ) return;
        //mark that row and col to identify it is visited already
        vis[row][col] = true;

        //go in all four direction and visit all the cell do not visit again same node or path, here row 
        //will become previous row as moving ahead

        //move row ahead means going down
        checkNmark(hi, vis, row+1, col, row, col);
        //move row backward means going up
        checkNmark(hi, vis, row-1, col, row, col);
        //move col ahead means going right
        checkNmark(hi, vis, row, col+1, row, col);
        //move col back means going left
        checkNmark(hi, vis, row, col-1, row, col);
    }
}