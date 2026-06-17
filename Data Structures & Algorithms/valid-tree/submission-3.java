class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        //For N node there should be n - 1 edges, will count lenght of edges
        int edgeCount = edges.length;
        if(n-1 != edgeCount) return false;

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                bfs(edges, i, vis, adjList);
                count++;
            }
        }
        return count == 1;
    }

    public void bfs(int[][] edges, int node, boolean[] vis, List<List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        vis[node] = true;

        while(!queue.isEmpty()) {
            int nd = queue.poll();
            for(int newNode: adjList.get(nd)) {
                if(!vis[newNode]) {
                    queue.offer(newNode);
                    vis[newNode] = true;
                }
            }
        }
    }
}
