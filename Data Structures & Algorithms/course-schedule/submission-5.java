class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < pre.length; i++) {
            adj.get(pre[i][1]).add(pre[i][0]);  
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!vis[i] && checkCycle(vis, pathVis, adj, i)) return false;
        }
        return true;
    }

    private boolean checkCycle(boolean[] vis, boolean[] pathVis, List<List<Integer>> adj, int node) {
        vis[node] = true;
        pathVis[node]= true;

        for(int child: adj.get(node)) {
            if(!vis[child] && checkCycle(vis, pathVis, adj, child)) return true;
            else 
                if(pathVis[child])  return true;
        }
        pathVis[node] = false;
        return false;
    }
}
