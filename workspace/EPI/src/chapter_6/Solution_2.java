/**
* Copyright ? Dec 7, 2013 
* EPI 5:42:15 PM
* Version 1.0
* All right reserved.
*
*/

package chapter_6;

/**
 * Class Description:
 * Author: zd987
 * Project Name: EPI
 * Create Time: Dec 7, 2013 5:42:15 PM
 * Version: 1.0
 */
public class Solution_2 {
	int[] b;
	int[] S, P;
	int t;
	public Solution_2(int n){
		b = new int[n];
		S = new int[n];
		P = new int[n];
		t = 0;
	}
	public int get(int k) throws Exception{
		if(P[k] >= 0 && P[k] < t){
			if(S[P[k]] == k){
				return b[k];
			}
		}
		throw new Exception();
	}
	public void write(int index, int val){
		try{
			this.get(index);
		} catch(Exception e){
			++t;
			P[index] = t;
			S[t] = index;
		}
		b[index] = val;
	}
}
