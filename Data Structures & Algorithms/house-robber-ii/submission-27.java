class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int first = robbingOpt(nums, 0, nums.length-2);
        int last = robbingOpt(nums, 1, nums.length-1);

        return Math.max(first, last);
    }

    public int robbingOpt(int[] nums, int ind, int last) {

        int prev1 = 0;
        int prev2 = 0;

        for(int i = last; i >=ind; i--) {
            int take = nums[i] + prev2;
            int nottake = prev1;
            prev2 = prev1;
            prev1 = Math.max(take, nottake);
        }
        return prev1;
    }
}
