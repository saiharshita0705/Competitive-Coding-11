// https://leetcode.com/problems/evaluate-reverse-polish-notation/

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, traverse along the string and if the number is smaller than st.peek() then remove top element and push smaller element into the stack.
 * Remove elements only k times. Take all the elements of the stack into a string builder and reverse it and convert into a string. Check for
 * leading zeroes and if length is greaterthan n-k then take substring of size n-k from start. Finally return the result string.
 */
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k) return "0";
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i = 0; i< n; i++){
            char ch = num.charAt(i);
            while(!st.isEmpty() && ch < st.peek() && count < k){
                    st.pop();
                    count++;
            }
            st.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        String result = sb.reverse().toString();
        if(result.length() > n-k) result = result.substring(0, n-k);
        while(result.charAt(0) == '0' && result.length()!=1){
            result = result.substring(1, result.length());
        }
        return result;
    }
}
