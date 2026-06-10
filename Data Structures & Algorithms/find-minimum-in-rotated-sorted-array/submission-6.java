class Solution {
    public int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        int beg = 0;
        int last = arr.length-1;

        while(beg <= last) {
            int mid = (beg+last)/2;
            
            if(arr[beg] <= arr[mid]) {
                min = Math.min(min, arr[beg]);
                beg = mid + 1;
            } else if(arr[last] > arr[mid]) {
                min = Math.min(min, arr[mid]);
                last = mid - 1;
            }
        }
        return min;
    }
}