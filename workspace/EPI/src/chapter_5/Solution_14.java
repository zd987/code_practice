/**
* Copyright ? Dec 7, 2013 
* EPI 4:55:34 PM
* Version 1.0
* All right reserved.
*
*/

package chapter_5;

/**
 * Class Description:
 * Author: zd987
 * Project Name: EPI
 * Create Time: Dec 7, 2013 4:55:34 PM
 * Version: 1.0
 */
public class Solution_14 {
	int divide(int x, int y){
		//only positive number
		if(x < y) return 0;
		int re = 0, i, j, k = 1;
		while(y <= x){
			re += k;
			x -= y;
			k *= 2;
			y *= 2;
		}
		return re;
	}
	public static void main(String[] args) {
		Solution_14 sol = new Solution_14();
		System.out.println(sol.divide(18, 5));
	}
}
