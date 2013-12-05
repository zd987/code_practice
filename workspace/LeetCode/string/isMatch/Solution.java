/**
* Copyright ? Nov 26, 2013 
* LeetCode 9:42:29 PM
* Version 1.0
* All right reserved.
*
*/

package string.isMatch;

/**
 * Class Description: Regular Expression Matching 
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 26, 2013 9:42:29 PM
 * Version: 1.0
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(p.length() == 0) return s.length() == 0;
        if(p.length() > 1 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || 
            (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && isMatch(s.substring(1), p));
        }
        return s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) && isMatch(s.substring(1), p.substring(1));
    }
}