class Solution {
    public int lengthOfLongestSubstring0(String s) {
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

    public int lengthOfLongestSubstring(String s) {
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
}