class Solution {
    public int countComponents(int n, int[][] edges) {
        int m = edges.length;

        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                count++;
                bfs(i, adj, vis);
            }
        }
        return count;
    }

    public void bfs(int node, List<List<Integer>> adj, boolean[] vis) {
        Queue<Integer> que = new LinkedList<>();
        que.add(node);
        vis[node] = true;

        while(!que.isEmpty()) {
            int n = que.poll();

            for(Integer next: adj.get(n)) {
                if(!vis[next]) {
                    vis[next] = true;
                    que.add(next);
                }
            }
        }
    }
}
