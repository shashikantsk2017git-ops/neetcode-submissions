class Solution {
    public int missingNumber(int[] nums) {
        int totalSum = (nums.length * (nums.length +1))/2;
        int currSum = 0;
        for(int i= 0; i<nums.length;i++) {
            currSum = currSum+nums[i];
        }
        return totalSum - currSum;
    }
}
