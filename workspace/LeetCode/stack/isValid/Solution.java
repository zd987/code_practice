/**
* Copyright ? Dec 4, 2013 
* LeetCode 9:20:18 PM
* Version 1.0
* All right reserved.
*
*/

package stack.isValid;

import java.util.HashMap;
import java.util.Stack;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 9:20:18 PM
 * Version: 1.0
 */
public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> m = new HashMap<Character, Character>();
        m.put(')', '(');
        m.put('}', '{');
        m.put(']', '[');
        Stack<Character> st = new Stack<Character>();
        int i, j, k, n = s.length();
        for(i = 0; i < n; ++i){
            Character ch = m.get(s.charAt(i));
            if(ch == null) {
                st.push(s.charAt(i));
            } else {
                if(st.isEmpty() || st.pop() != ch) return false;
            }
        }
        return st.isEmpty();
    }
}