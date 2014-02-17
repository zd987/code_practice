package feb_2014;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int search(int[] A, int target) {
        int i, j, k, low, high, mid, n = A.length;
        low = 0; high = n - 1;
        while(low <= high){
            mid = (low + high) / 2;
            if(A[mid] == target) return mid;
            else if(A[mid] < target){
                if((A[mid] < A[high] && A[high] >= target) || (A[mid] > A[high] && A[high] <= target)) low = mid + 1;
                else high = mid - 1;
            } else {
                if((A[mid] > A[low] && A[low] <= target)|| (A[mid] < A[low] && A[low] >= target)) high = mid - 1;
                else low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		int[] A = {4,5,6,7,8,1,2,3};
		int target = 8;
		System.out.println(sol.search(A, target));
	}
}