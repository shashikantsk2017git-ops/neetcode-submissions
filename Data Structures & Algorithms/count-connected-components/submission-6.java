class Solution {
    public int countComponents(int n, int[][] edges) {
        //convert into adj list

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        //TO make visited take array
        boolean[] vis = new boolean[n];

        //Start from 0th node and check for all node
        //Will check how many time will it take to traverse everything
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                bfs(adjList, vis, i);
                count++;
            }
        }
        return count;
    }

    public void bfs(List<List<Integer>> adjList, boolean[] vis, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        vis[node] = true;

        while(!queue.isEmpty()) {
            int oldNode = queue.poll();
            for(int child: adjList.get(oldNode)) {
                if(!vis[child]) {
                    queue.add(child);
                    vis[child] = true;;
                }
            }
        }
    }
}