class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 1; i <= 32; i++) {
            int temp = (n & 1) << (32-i);
            res = res + temp;
            n = n >> 1;
        }
        return res;
    }
}
