class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int l = 0, r = nums1.length;
        int totalLength = nums1.length + nums2.length;

        while(l <= r){
            int part1 = l + (r - l) / 2;
            int part2 = (totalLength + 1) / 2 - part1;

            int l1 = part1 > 0 ? nums1[part1 - 1] : Integer.MIN_VALUE;
            int r1 = part1 < nums1.length ? nums1[part1] : Integer.MAX_VALUE;

            int l2 = part2 > 0 ? nums2[part2 - 1] : Integer.MIN_VALUE;
            int r2 = part2 < nums2.length ? nums2[part2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                if(totalLength % 2 != 0){
                    return Math.max(l1, l2);
                }
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
            else if(l1 > r2){
                r = part1 - 1;
            }
            else {
                l = part1 + 1;
            }
        }
        return 0.0;
    }
}
