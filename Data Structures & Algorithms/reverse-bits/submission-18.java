class Solution {
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