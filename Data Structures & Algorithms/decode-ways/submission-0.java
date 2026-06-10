class Solution {
    Set<String> set = new HashSet<>();

    public int numDecodings(String s) {
        for (int i = 1; i <= 26; i++) {
            set.add(i + "");
        }
        return decode(s, 0);
    }

    public int decode(String s, int ind) {
        // Base case: reached end of string — valid decoding found
        if (ind == s.length()) return 1;

        // Current character is '0' — can't decode, no valid path
        if (s.charAt(ind) == '0') return 0;

        // Take 1 character
        int count = decode(s, ind + 1);

        // Take 2 characters (if within bounds and valid)
        if (ind + 2 <= s.length() && set.contains(s.substring(ind, ind + 2))) {
            count += decode(s, ind + 2);
        }

        return count;
    }
}