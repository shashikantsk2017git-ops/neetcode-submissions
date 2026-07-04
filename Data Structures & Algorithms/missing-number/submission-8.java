class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for(int num: nums) {
            xor = num ^ xor;
        }

        for(int i = 0; i <= nums.length; i++) {
            xor = xor ^ i;
        }
        return xor;
    }
}
