class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);

        int sufp = 1;
        int prefp = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefp * res[i];
            prefp = prefp * nums[i];

            res[n - 1 - i] = res[n - 1 - i] * sufp;
            sufp = sufp * nums[n - 1 - i];
        }
        return res;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int sufp = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            sufp = sufp * nums[i + 1];
            res[i] = res[i] * sufp;
        }
        return res;
    }

    public int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        int prefp = 1;
        for (int i = 1; i < nums.length; i++) {
            prefp = prefp * nums[i - 1];
            res[i] = prefp;
        }

        int sufp = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            sufp = sufp * nums[i + 1];
            res[i] = res[i] * sufp;
        }
        return res;
    }

    public int[] productExceptSelf0(int[] nums) {
        int[] pres = new int[nums.length];
        int[] sres = new int[nums.length];
        Arrays.fill(pres, 1);
        Arrays.fill(sres, 1);

        int ppref = 1;
        for (int i = 1; i < nums.length; i++) {
            ppref = ppref * nums[i - 1];
            pres[i] = ppref;
        }

        int psuf = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            psuf = psuf * nums[i + 1];
            sres[i] = psuf;
        }

        for (int i = 0; i < nums.length; i++) {
            pres[i] = pres[i] * sres[i];
        }

        return pres;
    }
}
