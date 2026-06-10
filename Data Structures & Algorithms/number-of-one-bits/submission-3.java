class Solution {
    public int hammingWeight1(int n) {
        int count = 0;
        while(n > 0) {
            if((n & 1) == 1) count++;
            n = n>>1;
        }
        return count;
    }

    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0) {
            if((n & 1) == 1) count++;
            n = n/2;
        }
        return count;
    }
}
