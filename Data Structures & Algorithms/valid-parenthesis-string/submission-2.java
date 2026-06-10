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
                maxopen++; //if * become ( 
                minopen--; //if * become )
            }
            if(maxopen < 0) return false;
            if(minopen < 0) minopen = 0; // if * has to go empty it be this scenario
        }

        return minopen == 0;
    }
}
