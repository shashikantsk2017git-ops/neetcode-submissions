class Solution {
    public int getSum(int a, int b) {
        while(b != 0) {
            int xor = a ^ b;
            int carray = (a & b) << 1;

            a = xor;
            b = carray;
        }
        return a;
    }
}
