/**
* Copyright ? Dec 1, 2013 
* LeetCode 10:29:50 PM
* Version 1.0
* All right reserved.
*
*/

package dfs.generateParenthesis;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 1, 2013 10:29:50 PM
 * Version: 1.0
 */
public class Solution {
    private ArrayList<String> helper(int ln, int rn){
        ArrayList<String> re = new ArrayList<String>();
        if(ln == 0){
            char[] chs = new char[rn];
            Arrays.fill(chs, ')');
            re.add(new String(chs));
            return re;
        }
        if(ln > 0) {
            for(String back : helper(ln - 1, rn + 1)){
                re.add("(" + back);
            }
        }
        if(rn > 0) {
            for(String back : helper(ln, rn - 1)){
                re.add(")" + back);
            }
        }
        return re;
    }
    public ArrayList<String> generateParenthesis(int n) {
        return helper(n, 0);
    }
}