class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ nums.length;
    }

    public int missingNumber0(int[] nums) {
        int sum = 0;
        for(int num: nums) sum = sum ^ num;

        int sumShould = 0;
        for(int i = 0; i <= nums.length; i++) {
            sumShould = sumShould ^ i;
        }
        return sumShould ^ sum;
    }
}
