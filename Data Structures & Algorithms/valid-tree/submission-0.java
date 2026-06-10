class Solution {
    public boolean validTree(int n, int[][] edges) {
        int m = edges.length;
        if(m != n - 1) return false;

        boolean vis[] = new boolean[n];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int count = 1;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        vis[0] = true;

        while(!que.isEmpty()) {
            int node = que.poll();

            for(Integer next: adj.get(node)) {
                if(!vis[next]) {
                    que.add(next);
                    vis[next] = true;
                    count++;
                }
            }
        }

        return count == n;
    }
}
