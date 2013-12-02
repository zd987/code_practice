/**
* Copyright ? Dec 2, 2013 
* LeetCode 9:28:36 PM
* Version 1.0
* All right reserved.
*
*/

package details.isPalindrome;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 9:28:36 PM
 * Version: 1.0
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        long k = 1, j = 1;
        while(k <= x) k *= 10;
        k /= 10;
        while(k > j){
            int left = (int) ((x / k) % 10);
            int right = (int) ((x / j) % 10);
            if(left != right) return false;
            k /= 10;
            j *= 10;
        }
        return true;
    }
}
