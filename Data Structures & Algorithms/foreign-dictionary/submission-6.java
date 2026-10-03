class Solution {
    public String foreignDictionary(String[] words) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < 26; i++) adjList.add(new ArrayList<>());

        Set<Integer> set = new HashSet<>();
        for(String word: words) {
            for(char c: word.toCharArray()) {
                set.add(c -'a');
            }
        }

        for(int i = 1; i < words.length; i++) {
            String s1 = words[i-1];
            String s2 = words[i];

            if(s1.length() > s2.length() && s1.substring(0, s2.length()).equals(s2)) return "";
            for(int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                if(s1.charAt(j) != s2.charAt(j)) {
                    adjList.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }

        return isCycleTopoSort(adjList, set);
    }

    private String isCycleTopoSort(List<List<Integer>> adjList, Set<Integer> set) {
        int[] indegree = new int[26];

        //Find indegree for all nodes
        for(int i: set) {
            for(int child: adjList.get(i)) {
                indegree[child]++;
            }
        }

        //check for 0 incoming nodes
        Queue<Integer> queue = new LinkedList<>();
        for(int i: set) {
            if(indegree[i] == 0) queue.add(i);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append((char)(node+'a'));
            count++;

            for(int child: adjList.get(node)) {
                indegree[child]--;
                if(indegree[child] == 0) {
                    queue.add(child);
                }
            }
        }
        if(count == set.size()) return new String(sb);
        return "";
    }
}
