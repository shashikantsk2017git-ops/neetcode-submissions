class Solution {
    public String foreignDictionary(String[] words) {
        //Create Adj list
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < 26; i++) adjList.add(new ArrayList<>());

        //As 26 leters we have but we might not get all in words so keep set to rember what actually
        //comes
        Set<Integer> set = new HashSet<>();
        for(String word: words) {
            for(char c: word.toCharArray()) {
                set.add(c -'a');
            }
        }

        for(int i = 1; i < words.length; i++) {
            //As we have list of words we need to comapare two at a time so took two
            String s1 = words[i-1];
            String s2 = words[i];

            //Any dictonary is invalid if first word is longer then second and both string is matching
            //for equal length - so return empty string
            if(s1.length() > s2.length() && s1.substring(0, s2.length()).equals(s2)) return "";

            //For each word start matching both word for 0 to N length N is min of s1 and s2 
            //because of matching 
            for(int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                if(s1.charAt(j) != s2.charAt(j)) {
                    //if not matching that means s1 char at j comes before s2 char at j
                    //so we can consider node s1 connects to s2
                    adjList.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    //if not matching break we found comparision if matching go beyond till non
                    //matching
                    break;
                }
            }
        }

        //Topological sort (toposort) takes DAG and produces a linear ordering of its nodes 
        //such that for every edge u → v, node u appears before v in the ordering.
        return isCycleTopoSort(adjList, set);
    }

    private String isCycleTopoSort(List<List<Integer>> adjList, Set<Integer> set) {
        int[] indegree = new int[26];

        //Keep indegree of every nodes so that we can know how many incoming edges are there
        for(int i: set) {
            for(int child: adjList.get(i)) {
                indegree[child]++;
            }
        }

        //Check for node with 0 indegree means we can start traversing from there 
        Queue<Integer> queue = new LinkedList<>();
        for(int i: set) {
            if(indegree[i] == 0) queue.add(i);
        }

        //Keep to check cycle in graph
        int count = 0;
        //Keep to check topo sort answer 
        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append((char)(node+'a'));
            count++;
            //increase count to calculate 0 indegree node 
            for(int child: adjList.get(node)) {
                //decrease child indegree as parent we alaready de queued
                //if zero then add means no incoming edge from any other node
                indegree[child]--;
                if(indegree[child] == 0) {
                    queue.add(child);
                }
            }
        }
        //if count is equals to no of nodes then no cycle we can return topo sort
        if(count == set.size()) return new String(sb);
        return "";
    }
}
