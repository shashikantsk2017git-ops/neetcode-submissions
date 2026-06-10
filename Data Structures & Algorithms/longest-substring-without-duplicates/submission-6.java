class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(j < s.length()) {
            char c = s.charAt(j);
            if(map.containsKey(c) && (map.get(c) >= i)) {
                i = map.get(c)+1;
            }
            map.put(c, j);
            int len = j -i + 1;
            maxLen = Math.max(maxLen, len);
            j++;
        }

        return maxLen;
    }
}

