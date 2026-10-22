class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MIN_VALUE;
        int max = 0;

        for(int weight: weights) {
            min = Math.max(weight, min);
            max += weight;
        }

        //binary search
        while(min <= max) {
            int mid = (min + max)/2;
            if(canShip(weights, mid, days)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean canShip(int[] weights, int targetWeight, int days) {

        int countDays = 1;
        int sum = 0;
        for(int i = 0; i < weights.length; i++) {
            if(weights[i] + sum <= targetWeight) {
                sum += weights[i];
            } else {
                sum = weights[i];
                countDays++;
            }
        }

        return countDays <= days;
    }
}