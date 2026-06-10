class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFrq = 0;
        int maxLen = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0)+1);
            maxFrq = Math.max(maxFrq, map.get(c));
            int len = right - left + 1;
            if(len - maxFrq <= k) {
                maxLen = Math.max(maxLen, len);
            }
            else {
                char startingChar = s.charAt(left);
                map.put(startingChar, map.getOrDefault(startingChar, 0)-1);    
                left++;
            }
            right++;
        }
        return maxLen;
    }
}