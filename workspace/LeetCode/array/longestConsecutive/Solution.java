/**
* Copyright ? Dec 5, 2013 
* LeetCode 7:57:00 PM
* Version 1.0
* All right reserved.
*
*/

package array.longestConsecutive;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 7:57:00 PM
 * Version: 1.0
 */
public class Solution {
    public int longestConsecutive(int[] num) {
        int i, j, k, n = num.length, re = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(i = 0; i < n; ++i){
            set.add(num[i]);
        }
        for(i = 0; i < n; ++i){
            if(!set.contains(num[i])) continue;
            set.remove(num[i]);
            j = num[i] - 1;
            while(set.contains(j)) {
                set.remove(j);
                --j;
            }
            k = num[i] + 1;
            while(set.contains(k)){
                set.remove(k);
                ++k;
            }
            re = Math.max(re, k - j - 1);
        }
        return re;
    }
}