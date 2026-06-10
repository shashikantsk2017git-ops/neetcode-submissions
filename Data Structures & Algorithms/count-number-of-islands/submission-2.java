class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    count++;
                    check(grid, vis, i, j);
                }
            }
        }
        return count;
    }

    public void check(char[][] grid, boolean[][] vis, int row, int col) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(row, col));
        vis[row][col] = true;

        int[] rows = {-1, 1, 0, 0};
        int[] cols = {0, 0, 1, -1};

        while(!que.isEmpty()) {
            Pair p = que.poll();
            int r = p.first;
            int c = p.second;

            for(int i = 0; i < 4; i++) {
                int nr = r + rows[i];
                int nc = c + cols[i];
                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[nr].length 
                    && grid[nr][nc] == '1' && !vis[nr][nc]
                ) {
                    que.add(new Pair(nr, nc));
                    vis[nr][nc] = true;
                }
            }

        }
    }
}

class Pair {
    int first;
    int second;

    public Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
}