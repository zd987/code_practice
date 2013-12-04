/**
* Copyright ? Dec 4, 2013 
* LeetCode 10:29:06 PM
* Version 1.0
* All right reserved.
*
*/

package stack.evalRPN;

import java.util.Stack;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 10:29:06 PM
 * Version: 1.0
 */
public class Solution {
	public int evalRPN(String[] tokens) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<Integer> st = new Stack<Integer>();
        int i, j, k, n = tokens.length;
        for(i = 0; i < n; ++i){
            String s = tokens[i];
            if(s.length() == 1 && !(s.charAt(0) >= '0' && s.charAt(0) <= '9')) {
                int op2 = st.pop();
                int op1 = st.pop();
                int re = 0;
                switch(s.charAt(0)){
                case '+': 
                    re = op1 + op2;
                    break;
                case '-':
                    re = op1 - op2;
                    break;
                case '*':
                    re = op1 * op2;
                    break;
                case '/':
                    re = op1 / op2;
                    break;
                }
                st.push(re);
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		String[] ss = {"0","3","/"};
		sol.evalRPN(ss);
	}
}