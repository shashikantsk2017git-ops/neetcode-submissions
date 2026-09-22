class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (!vis[row][col] && grid[row][col] == '1') {
                    bfs(row, col, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, boolean[][] vis, char[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));

        int[] rowsD = new int[] {-1, 0, 1, 0};
        int[] colsD = new int[] {0, -1, 0, 1};

        vis[row][col] = true;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                int r = pair.row + rowsD[i];
                int c = pair.col + colsD[i];

                if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1'
                    && !vis[r][c]) {
                    queue.add(new Pair(r, c));
                    vis[r][c] = true;
                }
            }
        }
    }
}

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
