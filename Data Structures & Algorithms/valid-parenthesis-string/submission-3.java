class Solution {
    public boolean checkValidString(String s) {
        int maxopen = 0;
        int minopen = 0;

        for(char c: s.toCharArray()) {
            if(c == '(') {
                maxopen++;
                minopen++;
            } else if(c == ')') {
                maxopen--;
                minopen--;
            } else {
                maxopen++;
                minopen--;
            }
            if(minopen < 0) minopen = 0;
            if(maxopen < 0) return false;
        }
        return minopen == 0;
    }
}
