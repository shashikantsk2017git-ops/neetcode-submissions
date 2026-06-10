class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i< s.length(); i++) {
            count += pal(s, i , i);
            count += pal(s, i-1, i);
        }
        return count;
    }

    public int pal(String s, int low, int high) {
        int count = 0;
        while(low >-1 && high < s.length() && s.charAt(low--) == s.charAt(high++)) {
            count++;
        }
        return count;
    }
}
