class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePath(m-1, n-1);
    }

    public int uniquePath(int m, int n) {
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;

        int down = uniquePath(m-1, n);
        int right = uniquePath(m, n-1);
        return down + right;
    }
}
