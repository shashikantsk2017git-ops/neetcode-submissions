class Solution {
    public int characterReplacement(String s, int k) {
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
