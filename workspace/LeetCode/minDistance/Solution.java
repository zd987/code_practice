/**
* Copyright ? Nov 29, 2013 
* LeetCode 6:28:22 AM
* Version 1.0
* All right reserved.
*
*/

package minDistance;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 29, 2013 6:28:22 AM
 * Version: 1.0
 */
public class Solution {
	public int minDistance2(String word1, String word2) {
        int i, j, k, n1 = word1.length(), n2 = word2.length();
        int[][] f = new int[n1 + 1][n2 + 1];
        for(i = 0; i <= n1; ++i){
            f[i][0] = i;
        }
        for(i = 0; i <= n2; ++i){
            f[0][i] = i;
        }
        for(i = 1; i <= n1; ++i){
            for(j = 1; j <= n2; ++j){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    f[i][j] = f[i -1][j -1];
                } else {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        return f[n1][n2];
    }
	public int minDistance(String word1, String word2) {
        int i, j, k, n1 = word1.length(), n2 = word2.length();
        //if(n1 > n2) return minDistance(word2, word1);
        int[] f = new int[n2 + 1];
        for(i = 0; i <= n2; ++i){
            f[i] = i;
        }
        for(i = 1; i <= n1; ++i){
            k = f[0];
            f[0] = i;
            for(j = 1; j <= n2; ++j){
                int t = f[j];
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    f[j] = k;
                } else {
                    f[j] = Math.min(f[j], f[j - 1]) + 1;
                    f[j] = Math.min(f[j], k + 1);
                }
                k = t;
            }
        }
        return f[n2];
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		sol.minDistance( 	"distance", "substance");
				
	}
}