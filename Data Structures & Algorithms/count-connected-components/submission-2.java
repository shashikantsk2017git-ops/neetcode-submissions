class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                count++;
                bfs(i, adj, vis);
            }
        }
        return count;
    }    
        
    public void bfs(int ind, List<List<Integer>> adj, boolean[] vis) {
        Queue<Integer> que = new LinkedList<>();
        que.add(ind);

        vis[ind] = true;

        while(!que.isEmpty()) {
            int out = que.poll();

            for(int nbr: adj.get(out)) {
                if(!vis[nbr]) {
                    vis[nbr] = true;
                    que.add(nbr);
                }
            }
        }
    }
}


