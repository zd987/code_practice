/**
* Copyright ? Dec 7, 2013 
* EPI 5:06:34 PM
* Version 1.0
* All right reserved.
*
*/

package chapter_6;

/**
 * Class Description:
 * Author: zd987
 * Project Name: EPI
 * Create Time: Dec 7, 2013 5:06:34 PM
 * Version: 1.0
 */
public class Solution_1 {
	void partition(int[] A, int index){
		int n = A.length, i = 0, j = n - 1, k = 0, pivot = A[index], tmp;
		while(i <= j){
			if(A[k] < pivot) {
				tmp = A[i];
				A[i++] = A[k];
				A[k++] = tmp;
			} else if(A[k] > pivot){
				tmp = A[j];
				A[j--] = A[k];
				A[k] = tmp;
			} else {
				++k;
			}
		}
		for(k = i; k <= j; ++k) A[k] = pivot;
	}
	public static void main(String[] args) {
		Solution_1 sol = new Solution_1();
		int[] A = {7,4,3,9,1,6,3,0};
		sol.partition(A, 2);
		System.out.println();
	}
}
