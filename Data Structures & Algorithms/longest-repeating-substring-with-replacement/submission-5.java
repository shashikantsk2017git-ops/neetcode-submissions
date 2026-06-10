class Solution {
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
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int i = 0;
        int j = 0;
        int maxf = 0;
        int maxLen = 0;

        while(j < s.length()) {
            char c = s.charAt(j);
            map[c-'A']++;
            maxf = Math.max(maxf, map[c-'A']);

            int len = j - i + 1;
            if(len - maxf <= k) {
                maxLen = Math.max(maxLen, len);
            } else {
                map[s.charAt(i)-'A']--;
                i++;
            }
            j++;
        }
        return maxLen;
    }
}

        