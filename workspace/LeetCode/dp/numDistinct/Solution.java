/**
* Copyright ? Nov 29, 2013 
* LeetCode 8:41:40 AM
* Version 1.0
* All right reserved.
*
*/

package dp.numDistinct;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 29, 2013 8:41:40 AM
 * Version: 1.0
 */
public class Solution {
	public int numDistinct(String S, String T) {
        int i, j, k, ns = S.length(), nt = T.length();
        if(nt > ns) return 0;
        if(nt == ns) {
            return S.equals(T) ? 1 : 0;
        }
        int[][] f = new int[ns + 1][nt + 1];
        for(i = 0; i <= ns; ++i){
            f[i][0] = 1;
        }
        for(i = 1; i <= ns; ++i){
            for(j = 1; j <= nt; ++j){
                f[i][j] = 0;
                if(T.charAt(j - 1) == S.charAt(i - 1)) {
                    f[i][j] += f[i - 1][j - 1];
                }
                f[i][j] += f[i - 1][j];
            }
        }
        return f[ns][nt];
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		sol.numDistinct("ccc", "c");
	}
}