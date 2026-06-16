class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int popped = st.pop();
                int currentArea = 0;
                if(st.isEmpty()){
                    currentArea = heights[popped] * i;
                }
                else{
                    currentArea = heights[popped] * (i - (st.peek() + 1)); 
                }
                maxArea = Math.max(currentArea, maxArea);
            }
        st.push(i);
        }
        while(!st.isEmpty()){
            int popped = st.pop();
            int currentArea = 0;
            if(st.isEmpty()){
                currentArea = heights[popped] * heights.length;
            }
            else{
                currentArea = heights[popped] * (heights.length - (st.peek() + 1)); 
            }
            maxArea = Math.max(currentArea, maxArea);
        }
        return maxArea;
    }
}
