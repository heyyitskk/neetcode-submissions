class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length - 1;
        int maxCap = 0;
        while(i < j){
            int curCap = Math.min(heights[i], heights[j]) * (j - i);
            maxCap = Math.max(maxCap, curCap);
            if(heights[i] < heights[j]) i++;
            else j--;
        }
        return maxCap;
    }
}
