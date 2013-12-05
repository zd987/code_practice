/**
* Copyright ? Dec 5, 2013 
* LeetCode 9:40:23 PM
* Version 1.0
* All right reserved.
*
*/

package array.grayCode;

import java.util.ArrayList;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 9:40:23 PM
 * Version: 1.0
 */
public class Solution {
	public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> re = new ArrayList<Integer>();
        int i, j, k;
        re.add(0);
        for(i = 0; i < n; ++i){
            k = 1 << i;
            for(j = re.size() - 1; j >= 0; --j){
                re.add(re.get(j) | k);
            }
        }
        return re;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		sol.grayCode(2);
	}
}