/**
* Copyright ? Dec 3, 2013 
* LeetCode 7:54:17 PM
* Version 1.0
* All right reserved.
*
*/

package details.getRow;

import java.util.ArrayList;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 7:54:17 PM
 * Version: 1.0
 */
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> cur = new ArrayList<Integer>();
        cur.add(1);
        if(rowIndex == 0) return cur;
        int i, j, k;
        for(i = 1; i <= rowIndex; ++i){
            cur.add(1);
            for(j = i - 1; j > 0; --j){
                cur.set(j, cur.get(j) + cur.get(j - 1));
            }
        }
        return cur;
    }
}
