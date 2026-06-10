class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;

        while(left <= right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(!Character.isLetterOrDigit(l)) {
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(r)) {
                right--;
                continue;
            }
            if(l != r) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
