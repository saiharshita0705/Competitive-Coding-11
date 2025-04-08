// https://leetcode.com/problems/evaluate-reverse-polish-notation/

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, traverse along the string array and if its a dight push it into the stack else if its an operator, take the 2 elements out of the stack
 * and do calculation with operator and put that result into the stack. Finally return st.pop().
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            char ch = tokens[i].charAt(0);
            if(Character.isDigit(ch) || tokens[i].length()>1){
                int num = Integer.parseInt(tokens[i]);
                st.push(num);
            }
            else if(ch == '+'){
                int curr = st.pop();
                int prev = st.pop();
                int result = curr + prev;
                st.push(result);
            }
            else if(ch == '-'){
                int curr = st.pop();
                int prev = st.pop();
                int result = prev - curr;
                st.push(result);
            }
            else if(ch == '*'){
                int curr = st.pop();
                int prev = st.pop();
                int result = curr * prev;
                st.push(result);
            }
            else if(ch == '/'){
                int curr = st.pop();
                int prev = st.pop();
                int result = prev / curr;
                st.push(result);
            }
        }
        return st.pop();
    }
}