class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for(int[] pre: prerequisites) adj.get(pre[1]).add(pre[0]);

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!vis[i] && dfs(i, adj, vis, pathVis)) return false;
        }
        return true;

    }

    public boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;
        for(Integer neighbor: adj.get(node)) {
            if(!vis[neighbor] && dfs(neighbor, adj, vis, pathVis)) return true;
            else if(pathVis[neighbor]) return true;
        }
        pathVis[node] = false;
        return false;
    }
}