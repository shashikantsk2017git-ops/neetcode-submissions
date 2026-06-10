class Solution {
    public boolean canJump2(int[] nums) {
        int maxj = 1;
        for(int num: nums) {
            maxj--;
            if(maxj < 0) return false;
            maxj = Math.max(maxj, num);
        }
        return true;
    }

    public boolean canJump(int[] nums) {
        int maxJumpIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > maxJumpIndex) return false;
            maxJumpIndex = Math.max(maxJumpIndex, i+nums[i]);
        }
        return true;
    }
}
