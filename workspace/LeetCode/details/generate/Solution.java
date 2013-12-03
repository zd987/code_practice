/**
* Copyright ? Dec 3, 2013 
* LeetCode 7:49:53 PM
* Version 1.0
* All right reserved.
*
*/

package details.generate;

import java.util.ArrayList;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 7:49:53 PM
 * Version: 1.0
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        if(numRows == 0) return re;
        cur.add(1);
        re.add(cur);
        if(numRows == 1) return re;
        int i, j, k;
        for(i = 2; i <= numRows; ++i){
        	cur = new ArrayList<Integer>(cur);
            cur.add(1);
            for(j = i - 2; j > 0; --j){
                cur.set(j, cur.get(j) + cur.get(j - 1));
            }
            re.add(cur);
        }
        return re;
    }
}