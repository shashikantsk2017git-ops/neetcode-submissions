class Solution {
    Set<String> set = new HashSet<>();

    public int numDecodings(String s) {
        for (int i = 1; i <= 26; i++) {
            set.add(i + "");
        }
        return decode(s, 0);
    }

    public int decode(String s, int ind) {

        if (ind == s.length()) return 1;

        if (s.charAt(ind) == '0') return 0;

        int count = decode(s, ind + 1);

        // Take 2 characters (if within bounds and valid)
        if (ind+2 <= s.length() && Integer.parseInt(s.substring(ind,ind+2)) <= 26) {
            count += decode(s, ind + 2);
        }

        return count;
    }
}