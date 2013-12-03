/**
* Copyright ? Dec 3, 2013 
* LeetCode 6:09:42 AM
* Version 1.0
* All right reserved.
*
*/

package details.twoSum;

import java.util.HashMap;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 6:09:42 AM
 * Version: 1.0
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int i, j, k;
        for(i = 0; i < numbers.length; ++i){
            Integer  i2 = m.get(target - numbers[i]);
            if(i2 != null){
                int[] re = new int[2];
                re[0] = i2 + 1;
                re[1] = i + 1;
                return re;
            }
            m.put(numbers[i], i);
        }
        return null;
    }
}
