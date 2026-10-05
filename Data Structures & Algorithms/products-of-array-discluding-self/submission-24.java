class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        int suff = 1;
        int pref = 1;

        for(int i = 0; i < nums.length; i++) {
            res[i] = res[i] * pref;
            pref = pref * nums[i];

            res[nums.length - i - 1] = res[nums.length -i -1]  * suff;
            suff = suff * nums[nums.length - i - 1];
        }

        return res;
    }
}  
