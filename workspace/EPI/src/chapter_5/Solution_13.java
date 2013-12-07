/**
* Copyright ? Dec 7, 2013 
* EPI 4:30:18 PM
* Version 1.0
* All right reserved.
*
*/

package chapter_5;

/**
 * Class Description:
 * Author: zd987
 * Project Name: EPI
 * Create Time: Dec 7, 2013 4:30:18 PM
 * Version: 1.0
 */
public class Solution_13 {

	int add(int x, int y){
		int sum = 0, carry_in = 0, carry_out, ak, bk, k = 1;
		while(k != 0){
			ak = x & k;
			bk = y & k;
			carry_out = (ak & bk) | (ak & carry_in) | (bk & carry_in);
			sum |= ak ^ bk ^ carry_in;
			carry_in = carry_out << 1;
			k <<= 1;
		}
		return sum;
	}
	public int multiply(int x, int y){
		int re = 0, i, j, k = 0, c = 0;
		while(y != 0){
			if((y & 1) != 0) re = add(re, x);
			x <<= 1;
			y >>= 1;
		}
		return re;
	}
	/**
	 * Method Description: 
	 * Author: zd987 
	 * Project Name: EPI
	 * Class Name: Solution_13.java
	 * Version: 1.0
	 * Create Time: Dec 7, 2013 4:30:18 PM
	 * @param args void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_13 sol = new Solution_13();
		System.out.println(sol.multiply(11, 11));
	}

}
