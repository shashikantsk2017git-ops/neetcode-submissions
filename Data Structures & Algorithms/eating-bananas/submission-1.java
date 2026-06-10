class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = Integer.MIN_VALUE;

        for(int qty: piles) maxSpeed = Math.max(maxSpeed, qty);

        int left = 0;
        int right = maxSpeed;
        while(left < right) {
            int mid = (left + right)/2;
            int time = calculateTime(piles, mid);
            if(time > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int calculateTime(int[] piles, int speed) {
        int time = 0;
        for(int qty: piles) {
            int count = (int)Math.ceil((double)qty/speed);
            time += count;
        }
        return time;
    }
}