class Solution {
    public boolean canJump(int[] nums) {
        int maxj = nums[0];
        for(int i = 1; i<nums.length; i++) {
            maxj--;
            if(maxj < 0) return false;
            maxj = Math.max(maxj, nums[i]);
        }
        return true;
    }
}
