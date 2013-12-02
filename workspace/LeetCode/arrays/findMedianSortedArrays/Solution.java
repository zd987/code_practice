/**
* Copyright ? Dec 2, 2013 
* LeetCode 9:59:15 PM
* Version 1.0
* All right reserved.
*
*/

package arrays.findMedianSortedArrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 2, 2013 9:59:15 PM
 * Version: 1.0
 */
public class Solution {
	private int findK(int A[], int as, int aak, int B[], int bs, int bbk, int k){
        if(aak > bbk) return findK(B, bs, bbk, A, as, aak, k);
        if(aak == 0) return B[bs + k - 1];
    	if(k == 1) return Math.min(A[as], B[bs]);
        int ak = Math.min(aak, k / 2), bk = k - ak;
        if(A[as + ak - 1] == B[bs + bk - 1]) return A[as + ak - 1];
        else if(A[as + ak - 1] > B[bs + bk - 1]) return findK(A, as, aak, B, bs + bk, bbk - bk, k - bk);
        else return findK(A, as + ak, aak - ak, B, bs, bbk, k - ak);
        
    }
    public double findMedianSortedArrays(int A[], int B[]) {
        int n = A.length + B.length;
        if(n % 2 == 1) {
            return findK(A, 0, A.length, B, 0, B.length, (n + 1)/ 2);
        } else {
            return (findK(A, 0, A.length, B, 0, B.length, n / 2) + 
                findK(A, 0, A.length, B, 0, B.length, n / 2 + 1)) * 0.5;
        }
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = {0, 2};
		int[] B = {1, 2};
		double re = sol.findMedianSortedArrays(A, B);
		System.out.println(re);
	}
}
