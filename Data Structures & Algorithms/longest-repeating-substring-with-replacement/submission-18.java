class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int maxFrq = 0;
        int maxLen = 0;

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            // treats missing value as 0, so returns 0 + 1 = 1
            map[c - 'A']++;
            int len = right - left + 1;
            maxFrq = Math.max(maxFrq, map[c - 'A']);
            if (len - maxFrq <= k) {
                maxLen = Math.max(len, maxLen);
            } else {
                char ch = s.charAt(left);
                map[ch - 'A']--;
                left++;
            }
            right++;
        }
        return maxLen;
    }

    public int characterReplacement0(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFrq = 0;
        int maxLen = 0;

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            // treats missing value as 0, so returns 0 + 1 = 1
            map.put(c, map.getOrDefault(c, 0) + 1);
            int len = right - left + 1;
            maxFrq = Math.max(maxFrq, map.get(c));
            if (len - maxFrq <= k) {
                maxLen = Math.max(len, maxLen);
            } else {
                char ch = s.charAt(left);
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                left++;
            }
            right++;
        }
        return maxLen;
    }
}
