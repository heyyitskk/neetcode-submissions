class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int t1 = 0, t2 = 0;
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                st.push(st.pop() + st.pop());
            }
            else if(tokens[i].equals("-")){
                t2 = st.pop();
                t1 = st.pop();
                st.push(t1 - t2);
            }
            else if(tokens[i].equals("*")){
                st.push(st.pop() * st.pop());
            }
            else if(tokens[i].equals("/")){
                t2 = st.pop();
                t1 = st.pop();
                st.push(t1 / t2);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}
