class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int water = 0, leftMax = 0, rightMax = 0;
        while(i < j){
            if(height[i] <= height[j]){
                if(height[i] > leftMax){
                    leftMax = height[i];  
                }
                else{
                    water += leftMax - height[i];
                }
                i++;
            }
            else{
                if(height[j] > rightMax){
                    rightMax = height[j];
                }
                else{
                    water += rightMax - height[j];
                }
                j--;
            }
        }
        return water;
    }
}
