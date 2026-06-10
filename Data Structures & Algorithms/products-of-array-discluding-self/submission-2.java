class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];

        out[0] = 1;

        int prefp = 1;
        int sufp = 1;
        
        for(int i = 1; i < nums.length; i++) {
            prefp = prefp * nums[i-1];
            out[i] = prefp;
        }

        for(int i = nums.length - 2; i >=0; i--) {
            sufp = sufp * nums[i+1];
            out[i] = sufp * out[i];
        }
        return out;
    }
}  