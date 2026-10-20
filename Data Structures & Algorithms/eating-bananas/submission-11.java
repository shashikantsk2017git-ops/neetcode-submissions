class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = Integer.MIN_VALUE;

        for(int qty: piles) maxSpeed = Math.max(maxSpeed, qty);

        int left = 1;
        int right = maxSpeed;
        // int ans = 0;
        while(left < right) {
            int mid = (left + right)/2;
            int time = calculateTime(piles, mid);
            if(time > h) {
                left = mid + 1;
                // ans = left;
            } else {
                right = mid;
            }
        }
        // return ans;
        return left;
    }

    public int calculateTime(int[] piles, int speed) {
        int time = 0;
        for(int qty: piles) {
            // int count = (int)Math.ceil((double)qty/speed);
            int count = (qty + speed - 1)/speed; // to get ceil qty/speed (give you fraciton) + 
            //speed/speed (will add extra one) - 1/speed (will remove fraction) so total will give you ceil value 
            time += count;
        }
        return time;
    }
}