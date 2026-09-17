class Solution {
    public boolean validTree(int n, int[][] edges) {
        int edgecount = edges.length;
        if(edgecount + 1 != n) return false;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        vis[0] = true;

        int countNotVisited = 1;
        while(!que.isEmpty()) {
            int node = que.poll();
            for(int child: adjList.get(node)) {
                if(!vis[child]) {
                    vis[child] = true;
                    countNotVisited++;
                    que.add(child);
                }
            }
        }
        return n == countNotVisited;
    }
}