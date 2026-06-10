class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(right < s.length()) {
            if(map.containsKey(s.charAt(right)) && left <= map.get(s.charAt(right))) {
                left = map.get(s.charAt(right))+1;
            }
            map.put(s.charAt(right), right);
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            right++;
        }
        return maxLen;
    }
}

