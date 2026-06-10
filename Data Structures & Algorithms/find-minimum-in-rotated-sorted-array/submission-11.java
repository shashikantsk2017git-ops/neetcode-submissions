class Solution {
    public int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = arr.length-1;

        while(left <= right) {
            int mid = (left+right)/2;
            
            if(arr[left] <= arr[right]) {
                min = Math.min(min, arr[left]);
            }
            if(arr[left] <= arr[mid]) {
                min = Math.min(min, arr[left]);
                left = mid + 1;
            } else if(arr[right] > arr[mid]) {
                min = Math.min(min, arr[mid]);
                right = mid - 1;
            }
        }
        return min;
    }
}