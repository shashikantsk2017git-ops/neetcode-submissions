class Solution {
    public int rob(int[] nums) {
        int first = 0;
        int second = 0;
        int prev1 =0;
        if(nums.length == 1) 
            return nums[0];
        int prev2 = nums[0];
        
        for(int i= 1; i<nums.length-1; i++) {
            int temp = prev2;
            prev2 = Math.max(nums[i]+prev1, prev2);
            prev1 = temp;
        }
        first = prev2;

        prev1 = 0;
        prev2 = nums[1];
        for(int i=2; i< nums.length; i++) {
            int temp = prev2;
            prev2 = Math.max(nums[i]+prev1, prev2);
            prev1 = temp;
        }
        second = prev2;

        return Math.max(first, second);
    }
}
