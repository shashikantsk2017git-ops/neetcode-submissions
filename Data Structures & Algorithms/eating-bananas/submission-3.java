class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = Integer.MIN_VALUE;

        for(int qty: piles) maxSpeed = Math.max(maxSpeed, qty);

        int left = 1;
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
            // int count = (qty + speed - 1)/speed;
            time += count;
        }
        return time;
    }
}
// int max = Integer.MIN_VALUE;
//         for(int ban: piles) max = Math.max(max, ban);
//         return findSpeed(piles, max, h);
//     }

//     public int findSpeed(int[] piles, int max, int h) {
//         int low = 1, high = max;
//         while (low < high) {
//             int mid = (low + high) / 2;
//             if (timeTaken(piles, mid) > h) {
//                 low = mid + 1;
//             } else {
//                 high = mid;
//             }
//         }
//         return low;
//     }

//     public int timeTaken(int[] piles, int mid) {
//         int timeTaken = 0;
//         for (int ban : piles) timeTaken += (ban + mid - 1) / mid;
//         return timeTaken;