/**
* Copyright ? Dec 5, 2013 
* LeetCode 8:40:34 PM
* Version 1.0
* All right reserved.
*
*/

package array.fourSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 8:40:34 PM
 * Version: 1.0
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        int i, j, k, n = num.length; 
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        for(i = 0; i < n - 3; ++i){
            if(i > 0 && num[i - 1] == num[i]) continue;
            for(j = i + 1; j < n - 2; ++j){
                if(j > i + 1 && num[j - 1] == num[j]) continue;
                int low = j + 1, high = n - 1, t = target - num[i] - num[j];
                while(low < high){
                    int tmp = num[low] + num[high];
                    if(tmp == t){
                        if(low > j + 1 && num[low - 1] == num[low]) {
                            ++low; continue;
                        }
                        if(high < n - 1 && num[high + 1] == num[high]) {
                            --high; continue;
                        }
                        ArrayList<Integer> cur = new ArrayList<Integer>();
                        cur.add(num[i]);
                        cur.add(num[j]);
                        cur.add(num[low]);
                        cur.add(num[high]);
                        re.add(cur);
                        ++low; --high;
                    } else if(tmp > t) {
                        --high;
                    } else{
                        ++low;
                    }
                }
            }
        }
        return re;
    }
}