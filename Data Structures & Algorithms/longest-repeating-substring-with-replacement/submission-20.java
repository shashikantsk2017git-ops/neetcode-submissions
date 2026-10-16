class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int maxFrq = Integer.MIN_VALUE;

        int i = 0;
        int j = 0;

        while(j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
            maxFrq = Math.max(map.get(s.charAt(j)), maxFrq);

            int len = j - i + 1;
            if(len - maxFrq > k) {
                char ichar = s.charAt(i);
                map.put(ichar, map.get(ichar)-1);
                i++;
            } else {
                maxLen = Math.max(len, maxLen);
            }
            j++;
        }
        return maxLen;
    }
}
