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
}
