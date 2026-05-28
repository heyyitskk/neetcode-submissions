class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int water = 0, mH = 0;
        while(i < j){
            if(height[i] <= height[j] && mH < height[i]){
                mH = height[i];
                i++;
            }
            else if(height[j] < height[i] && mH < height[j]){
                mH = height[j];
                j--;
            }
            else if(mH >= height[i]){
                water += mH - height[i];
                i++;
            }
            else{
                water += mH - height[j];
                j--;
            }
        }
        return water;
    }
}
