class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int ban: piles) max = Math.max(max, ban);
        return findSpeed(piles, max, h);
    }

    public int findSpeed(int[] piles, int max, int h) {
        int low = 1, high = max;
        while (low < high) {
            int mid = (low + high) / 2;
            if (timeTaken(piles, mid) > h) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int timeTaken(int[] piles, int mid) {
        int timeTaken = 0;
        for (int ban : piles) timeTaken += (ban + mid - 1) / mid;
        return timeTaken;
    }
}
