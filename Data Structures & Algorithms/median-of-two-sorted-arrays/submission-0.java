class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int[] smaller = nums1;
        int[] larger = nums2;

        int low = 0, high = smaller.length;
        int totalElem = nums1.length + nums2.length;
        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (totalElem + 1) / 2 - partX;

            int l1 = partX == 0 ? Integer.MIN_VALUE : smaller[partX - 1];
            int r1 = partX == smaller.length ? Integer.MAX_VALUE : smaller[partX];

            int l2 = partY == 0 ? Integer.MIN_VALUE : larger[partY - 1];
            int r2 = partY == larger.length ? Integer.MAX_VALUE : larger[partY];

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
        return 0;
    }
}
