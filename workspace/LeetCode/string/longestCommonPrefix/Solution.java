/**
* Copyright ? Dec 5, 2013 
* LeetCode 6:25:10 AM
* Version 1.0
* All right reserved.
*
*/

package string.longestCommonPrefix;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 6:25:10 AM
 * Version: 1.0
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0, j = 0, k = 0, n = strs.length, len = Integer.MAX_VALUE;
        if(n == 0) return "";
        for(i = 0; i < n; ++i){
            if(strs[i].length() < len){
                len = strs[i].length();
                k = i;
            }
        }
        for(i = 0; i < len; ++i){
            for(j = 0; j < n; ++j){
                if(strs[j].charAt(i) != strs[k].charAt(i)) break;
            }
            if(j != n) break;
        }
        return strs[k].substring(0, i);
    }
}