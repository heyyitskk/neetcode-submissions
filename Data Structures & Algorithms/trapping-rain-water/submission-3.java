class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int i = 0, j = height.length - 1;
        int water = 0, leftMax = height[i], rightMax = height[j];
        while(i < j){
            if(leftMax < rightMax){
                i++;
                leftMax = Math.max(leftMax, height[i]);
                water += leftMax - height[i];
            }
            else{
                j--;
                rightMax = Math.max(rightMax, height[j]);
                water += rightMax - height[j];
            }
        }
        return water;
    }
}
