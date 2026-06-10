class Solution {
    public boolean validTree(int n, int[][] edges) {
        //check if n-1 edges are there and graph is connected

        int edgeCount = edges.length;
        if(n-1 != edgeCount) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());


        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        int countConnected = 1;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        vis[0] = true;

        while(!que.isEmpty()) {
            int node = que.poll();

            for(int child: adj.get(node)) {
                if(!vis[child]) {
                    que.add(child);
                    countConnected++;
                    vis[child] = true;
                }
            }
        }
        return n == countConnected ? true: false;
    }
}
