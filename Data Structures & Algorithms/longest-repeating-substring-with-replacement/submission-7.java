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

    public int characterReplacement0(String s, int k) {
        int[] mem = new int[26];

        int l = 0;
        int r = 0;
        int mf = 0;
        int ml = 0;
        while(r < s.length()) {
            mem[s.charAt(r)-'A']++;
            mf = Math.max(mf, mem[s.charAt(r)-'A']);
            int len = r - l + 1;
            if(len - mf <= k) {
                ml = Math.max(ml, len);
            } else {
                mem[s.charAt(l)-'A']--;
                l++;
            }
            r++;
        }
        return ml;
    }
}