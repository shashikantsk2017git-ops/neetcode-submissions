class Solution {
    public double findMedianSortedArrays0(int[] nums1, int[] nums2) {
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

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int i1 = 0; int i2 = 0;
        int ind1 = n/2 - 1;
        int ind2 = n/2;
        int count = 0;
        int ind1el = Integer.MIN_VALUE;
        int ind2el = Integer.MIN_VALUE;

        while(i1 < n1 && i2 < n2) {
            if(nums1[i1] <= nums2[i2]) {
                if(count == ind1) ind1el = nums1[i1];
                if(count == ind2) ind2el = nums1[i1];
                count++;
                i1++;
            } else {
                if(count == ind1) ind1el = nums2[i2];
                if(count == ind2) ind2el = nums2[i2];
                count++;
                i2++;
            }
        }

        while(i1 < n1) {
            if(count == ind1) ind1el = nums1[i1];
            if(count == ind2) ind2el = nums1[i1];
            count++;
            i1++;
        }
        while(i2 < n2) {
            if(count == ind1) ind1el = nums2[i2];
            if(count == ind2) ind2el = nums2[i2];
            count++;
            i2++;
        }

        if(n % 2 == 0) {
            return (double)(ind1el + ind2el)/2.0;
        }
        return ind2el;
    }
}
