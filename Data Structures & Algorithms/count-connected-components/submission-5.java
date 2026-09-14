class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        for(int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        int count = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                count++;
                checkPath(adjList, i, vis);
            }
        }
        return count;
    }

    private void checkPath(List<List<Integer>> adjList, int node, boolean[] vis) {
        Queue<Integer> que = new LinkedList<>();
        vis[node] = true;
        que.add(node);

        while(!que.isEmpty()) {
            int temp = que.poll();
            for(int child: adjList.get(temp)) {
                if(!vis[child]){
                    vis[child] = true;
                    que.add(child);
                }
            }
        }
    }
}
