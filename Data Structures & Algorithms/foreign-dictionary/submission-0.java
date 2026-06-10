class Solution {
    public String foreignDictionary(String[] words) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 26; i++) adjList.add(new ArrayList<>());

        // Collect unique characters present in the words
        Set<Integer> presentChars = new HashSet<>();
        for (String word : words)
            for (char c : word.toCharArray())
                presentChars.add(c - 'a');

        for (int i = 1; i < words.length; i++) {
            String s1 = words[i - 1];
            String s2 = words[i];

            // Bug 2 Fixed: prefix check must be BEFORE the loop
            if (s1.length() > s2.length() && s1.substring(0, s2.length()).equals(s2))
                return "";

            // Bug 1 Fixed: loop bound changed to min length to avoid IndexOutOfBoundsException
            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adjList.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        // Bug 3 Fixed: pass actual unique char count and indices, not always 26
        return isCycleBFS(presentChars, adjList);
    }

    public String isCycleBFS(Set<Integer> presentChars, List<List<Integer>> adj) {
        int[] indegree = new int[26];
        for (int i : presentChars)
            for (Integer it : adj.get(i))
                indegree[it]++;

        Queue<Integer> q = new LinkedList<>();
        for (int i : presentChars)
            if (indegree[i] == 0)
                q.add(i);

        int count = 0;
        StringBuilder output = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            output.append((char) ('a' + node));
            count++;
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }

        System.out.println(output);

        // cycle check: all present chars must appear in topological order
        if (count == presentChars.size())
            return output.toString();

        return "";
    }
}