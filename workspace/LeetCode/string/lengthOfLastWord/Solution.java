/**
* Copyright ? Dec 5, 2013 
* LeetCode 8:16:09 AM
* Version 1.0
* All right reserved.
*
*/

package string.lengthOfLastWord;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 8:16:09 AM
 * Version: 1.0
 */
public class Solution {
	public int lengthOfLastWord(String s) {
        int i, j, k, n = s.length();
        j = n - 1;
        while(j >= 0 && s.charAt(j) == ' ') --j;
        i = j - 1;
        while(i >= 0 && s.charAt(i) != ' ') --i;
        if(j < 0) return 0;
        return j - i;
    }
	public static void main(String[] args) {
		String[] tokens = "fs a  b".split(" ");
		System.out.println();
	}
}
