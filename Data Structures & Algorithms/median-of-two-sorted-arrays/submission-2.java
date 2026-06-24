class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0, high = nums1.length;
        int totalElem = nums1.length + nums2.length;
        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (totalElem + 1) / 2 - partX;

            int l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int r1 = partX == nums1.length ? Integer.MAX_VALUE : nums1[partX];

            int l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int r2 = partY == nums2.length ? Integer.MAX_VALUE : nums2[partY];

            if (l1 <= r2 && l2 <= r1) {
                if (totalElem % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2)
                high = partX - 1;
            else
                low = partX + 1;
        }
        return 0.0;
    }
}
