class Solution {
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;

        while(left <= right) {
            int mid = (left + right)/2;
            if(arr[mid] == target) return mid;
        
            if(arr[left] <= arr[right]) {
                if(target <= arr[right] && target >= arr[left]) {
                    if(arr[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }

                } else {
                    return -1;
                }
            }
            else if(arr[left] <= arr[mid]) {
                if(target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
