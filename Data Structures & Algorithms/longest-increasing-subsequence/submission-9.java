class Solution {
    public int lengthOfLIS(int[] nums) {
       return lis(nums, 0, -1);
    }

    public int lis(int[] nums, int ind, int prev) {
        if(ind == nums.length) {
            return 0;
        }

        int take = 0;
        //take
        if(prev == -1 || nums[prev] < nums[ind]) {
            take = 1 + lis(nums, ind+1, ind);

        }

        //Not take
        int nottake = 0 + lis(nums, ind+1, prev);

        return Math.max(nottake, take);
        
    }
}