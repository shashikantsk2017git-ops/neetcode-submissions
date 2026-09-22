class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int even = checkSubstring(s, i, i);
            int odd = checkSubstring(s, i, i + 1);
            count = count + even + odd;
        }
        return count;
    }

    private int checkSubstring(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
        return count;
    }
}
