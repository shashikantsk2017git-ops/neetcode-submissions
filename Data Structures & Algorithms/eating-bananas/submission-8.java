class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;

        for(int num: piles) {
            max = Math.max(max, num);
        }

        while(min <= max) {
            int mid = (min + max)/2;
            if(canFinish(piles, h, mid)) {
                max = mid - 1;
            } else {
                min = mid+1;
            }
        }
        return min;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        int count = 0;
        for(int num: piles) {
            count += (int)Math.ceil((double)num/k);
        }
        if(count > h) return false;
        else return true;
    }
}
