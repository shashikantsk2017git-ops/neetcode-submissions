class Solution {
    public boolean canJump(int[] nums) {
        int maxj = 1;
        for(int num: nums) {
            maxj--;
            if(maxj < 0) return false;
            maxj = Math.max(maxj, num);
        }
        return true;
    }

    public boolean canJump2(int[] nums) {
        int maxjumpIndex = 0;
        return true;
    }
}
