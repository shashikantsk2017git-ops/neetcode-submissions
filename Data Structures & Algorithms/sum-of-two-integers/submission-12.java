class Solution {
    public int getSum0(int a, int b) {
        while(b != 0) {
            int xor = a ^ b;
            int carray = (a & b) << 1;

            a = xor;
            b = carray;
        }
        return a;
    }

    public int getSum(int a, int b) {
        if(b == 0) return a;
        int xor = a ^ b;
        int carray = (a & b) << 1;

        a = xor;
        b = carray;
        return getSum(a, b);
    }
}
