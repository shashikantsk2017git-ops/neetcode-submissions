class Solution {
    public int getSum(int a, int b) {
        while(b != 0) {
            int xor = a ^ b; // addition without carry
            int carry = (a & b) << 1; // carry

            a = xor;
            b = carry;
        }
        return a;
    }
}
