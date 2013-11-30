/**
* Copyright ? Nov 30, 2013 
* LeetCode 9:50:30 AM
* Version 1.0
* All right reserved.
*
*/

package dp.wordBreak;

import java.util.HashSet;
import java.util.Set;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 30, 2013 9:50:30 AM
 * Version: 1.0
 */
public class Solution {
    public boolean wordBreak2(String s, Set<String> dict) {
        int i, j, k, n = s.length();
        boolean[][] f = new boolean[n][n];
        for(k = 1; k <= n; ++k){
            for(i = 0; i <= n - k; ++i){
                f[i][i + k - 1] = false;
                if(dict.contains(s.substring(i, i + k))){
                    f[i][i + k - 1] = true;
                    continue;
                }
                for(j = 1; j < k; ++j){
                    if(f[i][i + j - 1] && f[i + j][i + k - 1]){
                        f[i][i + k - 1] = true;
                        break;
                    }
                }
            }
        }
        return f[0][n - 1];
    }
    public boolean wordBreak(String s, Set<String> dict) {
        int i, j, k, n = s.length();
        boolean [] f = new boolean[n + 1];
        f[0] = true;
        for(i = 1; i <= n; ++i){
            for(j = i - 1; j >= 0; --j){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(sol.wordBreak(s, dict));
	}
}