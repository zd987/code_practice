/**
* Copyright ? Dec 5, 2013 
* LeetCode 8:18:45 PM
* Version 1.0
* All right reserved.
*
*/

package array.threeSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 8:18:45 PM
 * Version: 1.0
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int i, j, k, n = num.length;
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(i = 0; i < n - 2; ++i){
            if(i > 0 && num[i - 1] == num[i]) continue;
            for(j = i + 1; j < n - 1; ++j){
                if(j > i + 1 && num[j - 1] == num[j]) continue;
                int low = j + 1, high = n - 1, mid = -1, target = 0 - num[i] - num[j];
                while(low <= high){
                    mid = (low + high) / 2;
                    if(num[mid] == target) break;
                    else if(num[mid] > target) high = mid - 1;
                    else low = mid + 1;
                }
                if(low <= high){
                    ArrayList<Integer> cur = new ArrayList<Integer>();
                    cur.add(num[i]);
                    cur.add(num[j]);
                    cur.add(num[mid]);
                    re.add(cur);
                }
            }
        }
        return re;
    }
}