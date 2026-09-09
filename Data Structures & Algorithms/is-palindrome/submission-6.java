class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        s = s.toLowerCase();
        while(left <= right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(!Character.isLetterOrDigit(l)) left++;
            else if(!Character.isLetterOrDigit(r)) right--;
            else {
                if(l != r) return false;
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
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
