class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] nums = new int[n1 + n2];

        int i1 = 0; int i2 = 0;
        int i = 0;
        while(i1 < n1 && i2 < n2) {
            if(nums1[i1] <= nums2[i2]) {
                nums[i++] = nums1[i1++];
            } else {
                nums[i++] = nums2[i2++];
            }
        }

        while(i1 < n1) {
            nums[i++] = nums1[i1++];
        }
        while(i2 < n2) {
            nums[i++] = nums2[i2++];
        }

        int n = n1 + n2;
        if(n % 2 == 0) {
            return (double)(nums[n/2]+ nums[(n/2)-1])/2.0;
        }
        return nums[n/2];
    }
}
