/**
* Copyright ? Dec 5, 2013 
* LeetCode 6:36:36 AM
* Version 1.0
* All right reserved.
*
*/

package string.isNumber;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 6:36:36 AM
 * Version: 1.0
 */
public class Solution {
	public boolean isNumber(String s) {
        int i, j, k, p = 0, n = s.length();
        while(p < n && s.charAt(p) == ' ') ++p;
        if(p == n) return false;
        boolean b = false;
        if(s.charAt(p) == '+' || s.charAt(p) == '-') ++p;
        while(p < n && s.charAt(p) >= '0' && s.charAt(p) <= '9') {b = true; ++p;}
        if(p == n) return true;
        if(s.charAt(p) == '.'){
            ++p;
            while(p < n && s.charAt(p) >= '0' && s.charAt(p) <= '9') {b = true; ++p;}
        } 
        if(p == n) return b;
        if(s.charAt(p) == 'e') {
            if(!b) return false;
            ++p;
            if(p < n && (s.charAt(p) == '+' || s.charAt(p) == '-')) ++p;
            b = false;
        }
        while(p < n && s.charAt(p) >= '0' && s.charAt(p) <= '9') {b = true; ++p;}
        while(p < n && s.charAt(p) == ' ') ++p;
        return (p == n) && b;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		sol.isNumber(".");
	}
}
