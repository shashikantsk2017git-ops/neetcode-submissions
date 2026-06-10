class Solution {
    public String foreignDictionary(String[] words) {
        List<Set<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < 26; i++) adjList.add(new HashSet<>());

        Set<Integer> set = new HashSet<>();
        for(String word: words) {
            for(char c: word.toCharArray()) set.add(c - 'a');
        }

        for(int i = 1; i < words.length; i++) {
            String s1 = words[i-1];
            String s2 = words[i];
            for(int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                if(s1.length() > s2.length() && s1.substring(0, s2.length()).equals(s2)) return "";
                if(s1.charAt(j) != s2.charAt(j)) {
                    adjList.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        return isCycleBFS(set, adjList);
    }

    public String isCycleBFS(Set<Integer> set, List<Set<Integer>> adj) {
        int[] indegree = new int[26];
         for (int i : set) {
            for (Integer it : adj.get(i))
                indegree[it]++;
         }
    
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i: set) {
            if(indegree[i] == 0) {
                q.add(i); // Add all node to queue if indegree is zero
            }
        }
        int count = 0;
        StringBuilder output = new StringBuilder();// if want topo sort output
        while(!q.isEmpty()) {
            int node = q.poll();
            output.append((char)('a'+node)); // add topo sort output element ot list
            count++;
            for(Integer it: adj.get(node)) {
                indegree[it]--; // Reduce indegree of each adjacent of node that removed from queue in previous step
                if(indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        System.out.println(output); // print topo sort output
        if(count == set.size()) {
            return new String(output);
        }
        return "";
    }
}
