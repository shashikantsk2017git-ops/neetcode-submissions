class Solution {
    public int reverseBits0(int n) {
        int res = 0;
        for(int i = 1; i <= 32; i++) {
            int temp = (n & 1) << (32-i);
            res = res + temp;
            n = n >> 1;
        }
        return res;
    }

    public int reverseBits(int n) {
        int res = 0;
        int count = 31;
        while (count >= 0) {
            if ((n & 1) == 1) {
                res = res | (1 << count);
            }
            count--;
            n = n >> 1;
        }
        return res;
    }
}
