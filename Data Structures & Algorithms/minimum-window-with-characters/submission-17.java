class Solution {
    public String minWindow0(String s, String t) {
        int len = Integer.MAX_VALUE;
        int strInd = -1;


        for(int i = 0; i < s.length(); i++) {

            int[] mem = new int[256];
            for(int j = 0; j < t.length(); j++) mem[t.charAt(j)]++;
            int count = 0;

            for(int j = i; j < s.length(); j++) {
                if(mem[s.charAt(j)] > 0) count++;
                mem[s.charAt(j)]--;

                if(count == t.length()) {
                    if(len > (j - i + 1)) {
                        strInd = i;
                        len = j - i +1;
                    }
                    break;
                }
            }
        }
        return strInd == -1 ? "" : s.substring(strInd, strInd + len);
    }

    public String minWindow1(String s, String t) {
        int[] hash = new int[256];
        int minLen = Integer.MAX_VALUE;
        int strInd = -1;

        for(int j = 0; j < t.length(); j++) hash[t.charAt(j)]++;

        //count for each window
        for(int i = 0; i < s.length(); i++) {
            int count = 0;
            for(int j = i; j < s.length(); j++) {
                if(hash[s.charAt(j)] > 0) 
                    count++;

                hash[s.charAt(j)]--;
                while(count == t.length()) {
                    if(minLen > (j - i + 1)) {
                        minLen = j - i + 1;
                        strInd = i;
                    }
                    hash[s.charAt(i)]++;
                    if(hash[s.charAt(i)] > 0) count--;

                    i++;
                }
            }
        }
        return strInd == -1 ? "" : s.substring(strInd, strInd + minLen); 
    }

    public String minWindow(String s, String t) {
        int len = Integer.MAX_VALUE;
        int strInd = -1;

        int[] mem = new int[128];
        for(int j = 0; j < t.length(); j++) mem[t.charAt(j)]++;
        int i = 0;
        int count = 0;
            
        for(int j = i; j < s.length(); j++) {
            if(mem[s.charAt(j)] > 0) count++;
            mem[s.charAt(j)]--;

            while(count == t.length()) {
                if(len > (j - i + 1)) {
                    strInd = i;
                    len = j - i +1;
                    if(len == t.length()) return s.substring(strInd, strInd + len);
                }
                
                mem[s.charAt(i)]++;
                if(mem[s.charAt(i)] > 0) count--;
                i++;
            }
        }
        return strInd == -1 ? "" : s.substring(strInd, strInd + len);
    }
}
