class Solution {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        int[] hash = new int[128];
        for (char c : t.toCharArray()) hash[c]++;
        
        int required = t.length(); // chars still needed
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (hash[c] > 0) required--;
            hash[c]--;
            
            // shrink from the left while window is still valid
            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char lc = s.charAt(left);
                hash[lc]++;
                if (hash[lc] > 0) required++;
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public String minWindow1(String s, String t) {
        int[] hash = new int[256];
        int minLen = Integer.MAX_VALUE;
        int strInd = -1;

        for(int j = 0; j < t.length(); j++) hash[t.charAt(j)]++;

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


    public String minWindow0(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int strInd = -1;

        for(int i = 0; i < s.length(); i++) {

            int count = 0;
            int[] hash = new int[256];

            for(int j = 0; j < t.length(); j++) hash[t.charAt(j)]++;

            for(int j = i; j < s.length(); j++) {
                if(hash[s.charAt(j)]-- > 0) {
                    count++;
                }
                int len = j - i + 1;
                if(count == t.length()) {
                    if(minLen > len) {
                        strInd = i;
                        minLen = len;
                    }
                    break;
                }
            }
        }
        return strInd == -1 ? "" : s.substring(strInd, strInd + minLen);
    }
}
