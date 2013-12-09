/**
* Copyright ? Dec 7, 2013 
* EPI 6:57:26 PM
* Version 1.0
* All right reserved.
*
*/

package chapter_6;

/**
 * Class Description:
 * Author: zd987
 * Project Name: EPI
 * Create Time: Dec 7, 2013 6:57:26 PM
 * Version: 1.0
 */
public class Solution_3 {
	int minBattery(int[] A){
		int n = A.length, i, j, k, min = A[0], re = 0;
		for(i = 1; i < n; ++i){
			if(A[i] - min > re){
				re = A[i] - min;
			}
			min = Math.min(min, A[i]);
		}
		return re;
	}
}
