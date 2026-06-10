class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) 
            return nums[0];
        int first = best(nums, 1, nums.length-1, 0, nums[0]);
        int second = best(nums, 2, nums.length, 0, nums[1]);
        return Math.max(first, second);
    }

    public int best(int[] nums, int index, int last, int prev1, int prev2) {
        for(int i= index; i<last; i++) {
            int temp = prev2;
            prev2 = Math.max(nums[i]+prev1, prev2);
            prev1 = temp;
        }
        return prev2;
    }
}
