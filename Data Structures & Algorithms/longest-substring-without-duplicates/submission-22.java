class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while( right < s.length()) {
            char c = s.charAt(right);
            if(map.containsKey(c) && left <= map.get(c)) {
                left = map.get(c)+1;
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring0(String s) {
        int[] mem = new int[256];
        Arrays.fill(mem, -1);
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while( right < s.length()) {
            char c = s.charAt(right);
            if(mem[c] != -1 && left <= mem[c]) {
                left = mem[c]+1;
            }
            mem[c] =  right;
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring1(String s) {
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