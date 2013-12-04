/**
* Copyright ? Dec 4, 2013 
* LeetCode 9:11:19 PM
* Version 1.0
* All right reserved.
*
*/

package stack.longestValidParentheses;

import java.util.Stack;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 9:11:19 PM
 * Version: 1.0
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int i, j, k = 0, re = 0;
        Stack<Integer> st = new Stack<Integer>();
        for(i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '('){
                st.push(1 + k);
                k = 0;
            } else {
                if(st.isEmpty()){
                    k = 0;
                } else {
                    k += st.pop() + 1;
                    re = Math.max(re, k);
                }
            }
        }
        return re;
    }
}
