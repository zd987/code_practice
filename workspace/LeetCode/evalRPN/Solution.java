/**
* Copyright ? Nov 28, 2013 
* LeetCode 6:59:48 AM
* Version 1.0
* All right reserved.
*
*/

package evalRPN;

import java.util.Stack;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 28, 2013 6:59:48 AM
 * Version: 1.0
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<Integer> s = new Stack<Integer>();
        for(String t : tokens){
            boolean neg = false;
            int k = 0;
            if(t.charAt(0) == '-') {
                neg = true; ++k;
            }
            if(k < t.length() && t.charAt(k) >= '0' && t.charAt(k) <= '9') {
                s.push(Integer.parseInt(t));
                continue;
            }
            int p2 = s.pop();
            int p1 = s.pop();
            switch(t.charAt(0)){
            case '+':
                s.push(p1 + p2);
                break;
            case '-':
                s.push(p1 -p2);
                break;
            case '*':
                s.push(p1 * p2);
                break;
            case '/':
                s.push(p1 / p2);
                break;
            }
        }
        return s.pop();
    }
}