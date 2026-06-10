class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i < j) {
            if(!Character.isLetterOrDigit(s.charAt(i))) i++;
            else if(!Character.isLetterOrDigit(s.charAt(j))) j--;
            else {
                if(!s.substring(i, i+1).equalsIgnoreCase(s.substring(j, j+1))) {
                    return false;
                } 
                i++;
                j--;
            }
        }
        return true;
    }
}
