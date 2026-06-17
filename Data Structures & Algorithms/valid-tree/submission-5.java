class Solution {
    public boolean validTree(int n, int[][] edges) {
        int edgeCount = edges.length;
        if(edgeCount != n-1) return false;

        //Convert Matrix to adjency list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        
        for(int[] arr: edges) {
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }

        //Create Vis array to track visited
        boolean[] vis = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        vis[0] = true;
        int countVisited = 1;

        while(!que.isEmpty()) {
            int node = que.poll();
            for(int child: adjList.get(node)) {
                if(!vis[child]) {
                    vis[child] = true;
                    countVisited++;
                    que.add(child);
                }
            }
        }

        return n == countVisited;
    }
}
