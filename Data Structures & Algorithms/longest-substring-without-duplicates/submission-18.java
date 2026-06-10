class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0; 
        int j = 0;
        int len = 0;
        int[] mem = new int[256];
        Arrays.fill(mem, -1);

        while(j < s.length()) {
            if(mem[s.charAt(j)] !=-1 && mem[s.charAt(j)] >= i) {
                i = mem[s.charAt(j)]+1;
            }
            mem[s.charAt(j)] = j;
            len = Math.max(len, j - i + 1);
            j++;
        }
        return len;
    }

    public int lengthOfLongestSubstring1(String s) {
        int i = 0; 
        int j = 0;
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(j < s.length()) {
            if(map.containsKey(s.charAt(j)) && (i <= map.get(s.charAt(j)))) {
                i = map.get(s.charAt(j))+1;
            }
            map.put(s.charAt(j), j);
            len = Math.max(len, j - i + 1);
            j++;
        }
        return len;
    }
    public int lengthOfLongestSubstring0(String s) {
        int len = 0;
        for(int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int j = i;
            while(j < s.length()) {
                if(set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                j++;
            }
            len = Math.max(len, j - i);
        }
        return len;
    }
}