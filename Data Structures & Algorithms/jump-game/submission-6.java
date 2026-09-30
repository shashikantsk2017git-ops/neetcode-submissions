class Solution {
    public boolean canJump(int[] nums) {
        int prev = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] - (prev - i) >= 0) {
                prev = i;
            } 
        }
        return prev == 0;
    }

    public boolean canJump1(int[] nums) {
        int maxj = 1;
        for(int num: nums) {
            maxj--;
            if(maxj < 0) return false;
            maxj = Math.max(maxj, num);
        }
        return true;
    }

    public boolean canJump2(int[] nums) {
        int maxJumpIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > maxJumpIndex) return false;
            maxJumpIndex = Math.max(maxJumpIndex, i+nums[i]);
        }
        return true;
    }
}
