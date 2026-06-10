class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char c[] = s.toCharArray();
        int i = 0;
        int j = c.length-1;

        while(i < j) {
            if(!Character.isLetterOrDigit(c[i])) i++;
            else if(!Character.isLetterOrDigit(c[j])) j--;
            else {
                if(c[i] == c[j]) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
