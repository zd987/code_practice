/**
* Copyright ? Dec 3, 2013 
* LeetCode 8:19:45 PM
* Version 1.0
* All right reserved.
*
*/

package details.convert;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 8:19:45 PM
 * Version: 1.0
 */
public class Solution {
	public String convert(String s, int nRows) {
        int i = 0, j = 0, k, n = s.length();
        char[][] f = new char[nRows][n];
        for(i = 0; i < nRows; ++i)
            for(j = 0; j < n; ++j)
                f[i][j] = ' ';
        for(i = 0, j = 0, k = 0; k < n; ++k){
            f[i][j] = s.charAt(k);
            if(nRows <= 2) {
                ++i;
                if(i == nRows){
                    ++j; 
                    i = 0;
                }
            } else if(j % 2 == 0) {
                ++i;
                if(i == nRows) {
                    i = nRows - 2;
                    ++j;
                }
            } else {
                --i;
                if(i == 0){
                    ++j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(i = 0; i < nRows; ++i){
            for(j = 0; j < n; ++j){
                if(f[i][j] != ' ') {
                    sb.append(f[i][j]);
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		sol.convert("A", 1);
	}
}