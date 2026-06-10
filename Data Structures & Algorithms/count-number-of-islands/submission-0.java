class Solution {
    public int numIslands(char[][] grid) {
    boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(grid, vis, i, j);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, boolean[][] vis, int row, int col) {
        Queue<Pair> queue = new LinkedList<>();
        vis[row][col] = true;
        queue.add(new Pair(row, col));

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        while(!queue.isEmpty()) {
            int ro = queue.peek().first;
            int co = queue.peek().second;
            queue.remove();

            for(int i = 0; i < 4; i++) {
                int nrow = ro + dRow[i];
                int ncol = co + dCol[i];
                if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[nrow].length && grid[nrow][ncol] =='1' && !vis[nrow][ncol]) {
                        queue.add(new Pair(nrow, ncol));
                        vis[nrow][ncol] = true;
                    }
            }
        }
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}