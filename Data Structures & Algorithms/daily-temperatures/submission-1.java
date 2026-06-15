class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i = n - 1; i >= 0; i--){
            if(st.isEmpty()) {
                st.push(i);
                result[i] = 0;
            }
            else if(temperatures[i] >= temperatures[st.peek()]){
                while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                    st.pop();
                }
                if(st.isEmpty()) {
                    result[i] = 0;
                    st.push(i);
                }
                else {
                    result[i] = st.peek() - i;
                    st.push(i);
                }
            }
            else if(temperatures[i] < temperatures[st.peek()]){
                result[i] = st.peek() - i;
                st.push(i);
            }
        }
        return result;
    }
}
