class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
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
