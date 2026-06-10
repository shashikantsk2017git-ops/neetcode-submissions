class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int maxFrq = 0;
        while(j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0)+1);
            maxFrq = Math.max(maxFrq, map.get(c));
            int len = j - i +1;
            if(len - maxFrq <= k) {
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                i++;
            }
            j++;
        }
        return maxLen;
    }
}