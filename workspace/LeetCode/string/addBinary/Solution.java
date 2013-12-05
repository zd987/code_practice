/**
* Copyright ? Dec 4, 2013 
* LeetCode 11:36:19 PM
* Version 1.0
* All right reserved.
*
*/

package string.addBinary;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 4, 2013 11:36:19 PM
 * Version: 1.0
 */
public class Solution {
    public String addBinary(String a, String b) {
        int i, j, ii, jj, k, c, na = a.length(), nb = b.length();
        StringBuilder sb = new StringBuilder();
        for(c = 0, i = na - 1, j = nb - 1; i >= 0 || j >= 0; --i, --j){
            ii = i >= 0 ? a.charAt(i) - '0' : 0;
            jj = j >= 0 ? b.charAt(j) - '0' : 0;
            k = ii + jj + c;
            sb.append(k & 1);
            c = k >> 1;
        }
        if(c > 0) sb.append(c);
        return sb.reverse().toString();
    }
}