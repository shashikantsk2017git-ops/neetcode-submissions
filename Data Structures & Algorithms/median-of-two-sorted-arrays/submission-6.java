class Solution {
    public double findMedianSortedArrays0(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] nums = new int[n1 + n2];

        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while (i1 < n1 && i2 < n2) {
            if (nums1[i1] <= nums2[i2]) {
                nums[i++] = nums1[i1++];
            } else {
                nums[i++] = nums2[i2++];
            }
        }

        while (i1 < n1) {
            nums[i++] = nums1[i1++];
        }
        while (i2 < n2) {
            nums[i++] = nums2[i2++];
        }

        int n = n1 + n2;
        if (n % 2 == 0) {
            return (double) (nums[n / 2] + nums[(n / 2) - 1]) / 2.0;
        }
        return nums[n / 2];
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int i1 = 0;
        int i2 = 0;
        int ind1 = n / 2 - 1;
        int ind2 = n / 2;
        int count = 0;
        int ind1el = Integer.MIN_VALUE;
        int ind2el = Integer.MIN_VALUE;

        while (i1 < n1 && i2 < n2) {
            if (nums1[i1] <= nums2[i2]) {
                if (count == ind1) ind1el = nums1[i1];
                if (count == ind2) ind2el = nums1[i1];
                count++;
                i1++;
            } else {
                if (count == ind1) ind1el = nums2[i2];
                if (count == ind2) ind2el = nums2[i2];
                count++;
                i2++;
            }
        }

        while (i1 < n1) {
            if (count == ind1) ind1el = nums1[i1];
            if (count == ind2) ind2el = nums1[i1];
            count++;
            i1++;
        }
        while (i2 < n2) {
            if (count == ind1) ind1el = nums2[i2];
            if (count == ind2) ind2el = nums2[i2];
            count++;
            i2++;
        }

        if (n % 2 == 0) {
            return (double) (ind1el + ind2el) / 2.0;
        }
        return ind2el;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        //Run Binary search on smaller array
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = n1;

        //left is the part where arr1 will be 0 to N element comes and rest arr2 will come
        int left = (n1 + n2 + 1) / 2;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;

            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            //mid1 will have r2 because while selecting left we less towards left side and more 
            //towards right side and r is towards n length
            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];

            //for l1 or l2 why mid - 1 because less towards left side and l is towards 0th side
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 1)
                    return Math.max(l1, l2);
                return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2)
            //l1 is more, means to make it correct l1 should go right means it should be less
            //and it will be less if we select mid1 - 1 from higher side to make mid low
                high = mid1 - 1;
            else
            //if r1 is less means to make it correct l1 should be more so take more element 
            //so mid1+1
                low = mid1 + 1;
        }
        return 0;
    }
}
