class Solution {
    public int reverseBits(int n) {
        int res = 0;
        int pointer = 31;
        for(int i = 0; i<32; i++) {
            int lastBit = n & 1;
            int shiftLastBit = lastBit << (pointer);
            res = res | shiftLastBit; //OR will set shiftedBit to result
            pointer--; // decrease to set bit on 31, 30, 29......,1,0
            n = n >>> 1;
        }
        return res;
    }
}