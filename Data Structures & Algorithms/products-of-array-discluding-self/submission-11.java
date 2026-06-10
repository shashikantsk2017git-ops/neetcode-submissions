class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length-1;
        int[] res = new int[n+1];
        Arrays.fill(res, 1);
        
        int pref = 1, suff = 1;
        
        for (int i = 0; i <= n; i++) {
            res[i] = res[i] * pref;
            pref = pref * nums[i]; // pref for next element

            res[n - i ] = res[n - i ] * suff;
            suff = nums[n - i ] * suff;
        }
        
        return res;
    }

    public int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int n = nums.length-1;
        int suff = 1;

        for(int i = 1; i <= n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        for(int i = nums.length-2; i >=0; i--) {
            suff = suff * nums[i+1];
            res[i] = res[i]* suff;
        }

        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];
        
        pref[0] = 1;
        suff[nums.length-1] = 1;
        for(int i = 1; i < nums.length; i++) {
            pref[i] = pref[i-1] * nums[i-1];
        }

        for(int i = nums.length-2; i>=0; i--) {
            suff[i] = suff[i+1] * nums[i+1];
        }

        for(int i = 0; i < nums.length; i++) {
            pref[i] = pref[i] * suff[i];
        }

        return pref;
    }
}  