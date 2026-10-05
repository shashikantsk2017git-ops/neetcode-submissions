class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        //prefix product
        int pref = 1;
        for(int i = 0; i < nums.length; i++) {
            res[i] = res[i] * pref;
            pref = pref * nums[i];
        }

        int suff = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i]  * suff;
            suff = suff * nums[i];
        }

        return res;
    }
}  
