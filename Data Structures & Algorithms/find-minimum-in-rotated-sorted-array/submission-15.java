class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = (left+right)/2;

            if(nums[left] <= nums[right]) {
                min = Math.min(min, nums[left]);
            }

            if(nums[left] <= nums[mid]) {
                min = Math.min(min, nums[left]);
                left  = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            }
        }
        return min;
    }

    public int findMin1(int[] arr) {
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
            } 
            if(arr[right] > arr[mid]) {
                min = Math.min(min, arr[mid]);
                right = mid - 1;
            }
        }
        return min;
    }
}
