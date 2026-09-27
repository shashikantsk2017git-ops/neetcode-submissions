class Solution {

    public boolean checkInclusion1(String s1, String s2) {
        
        char c1[] = s1.toCharArray();
        Arrays.sort(c1);
        String ns1 = new String(c1);

        for(int i = 0; i <= s2.length() - s1.length(); i++) {

            char[] c2 = s2.substring(i, i + s1.length()).toCharArray();
            Arrays.sort(c2);
            String ns2 = new String(c2);
            if(ns1.equals(ns2)) return true;
        }
        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int[] ch1 = new int[26];
        int[] window = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            ch1[s1.charAt(i)-'a']++;
            //Will maintain window of size s1 so that matching will be easy
            window[s2.charAt(i)-'a']++; 
        }

        for(int i = 0; i < s2.length() - s1.length(); i++) {
            if(matches(ch1, window)) return true;

            //Update the window by removing ith element and adding i + s1.length() 
            window[s2.charAt(i)-'a']--;
            window[s2.charAt(i + s1.length()) -'a']++;
        }

        return matches(ch1, window); //Run final check on last window
    }

    private boolean matches(int[] ch1, int[] window) {
        for(int i = 0; i < 26; i++) {
            if(ch1[i] != window[i]) return false;
        }
        return true;
    }
    
    public boolean checkInclusion0(String s1, String s2) {
        return checkPermutation(s1.toCharArray(), 0, s2);
    }

    private boolean checkPermutation(char ch[], int ind, String s2) {
        if(ind == ch.length) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < ch.length; i++) {
                sb.append(ch[i]);
            }
            if(s2.contains(new String(sb))) return true;
            return false;
        }
        for(int i = 0; i < ch.length; i++) {
            swap(i, ind, ch);
            if(checkPermutation(ch, ind+1, s2)) return true;
            swap(ind, i, ch);
        }
        return false;
    }

    private void swap(int c1, int c2, char[] ch) {
        char temp = ch[c1];
        ch[c1] = ch[c2];
        ch[c2] = temp;
    }
    
}
