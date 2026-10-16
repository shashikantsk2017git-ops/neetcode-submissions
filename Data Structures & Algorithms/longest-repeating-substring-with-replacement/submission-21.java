class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int maxFrq = Integer.MIN_VALUE;

        int left = 0;
        int right = 0;

        while(right < s.length()) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0)+1);
            maxFrq = Math.max(map.get(rightChar), maxFrq);

            int len = right - left + 1;
            if(len - maxFrq > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);
                left++;
            } else {
                maxLen = Math.max(len, maxLen);
            }
            right++;
        }
        return maxLen;
    }
}
