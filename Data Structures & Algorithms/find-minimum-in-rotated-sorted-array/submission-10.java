class Solution {
    public int findMin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[left] <= arr[mid]) {
                min = Math.min(min, arr[left]);
                left = mid + 1;
            } else if (arr[mid] <= arr[right]) {
                min = Math.min(min, arr[mid]);
                right = mid - 1;
            } 
        }
        return min;
    }
}