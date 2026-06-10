class Solution {
    public int getSum(int a, int b) {
        if(b == 0) return a;
        int xor = a ^ b;
        int carry = (a & b) << 1;

        a = xor;
        b = carry;
        return getSum(a, b);
    }
}
