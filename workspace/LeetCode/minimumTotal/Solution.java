/**
* Copyright ? Nov 27, 2013 
* LeetCode 10:35:27 PM
* Version 1.0
* All right reserved.
*
*/

package minimumTotal;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Nov 27, 2013 10:35:27 PM
 * Version: 1.0
 */
public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        for(int i = triangle.size() - 2; i >= 0; -- i){
            for(int j = 0; j <= i; ++j){
                triangle.get(i).set(j, triangle.get(i).get(j) + 
                    Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
	public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(triangle.size() == 0) return 0;
        int[] f = new int[triangle.size() + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        int i, j, re = Integer.MAX_VALUE;
        f[1] = triangle.get(0).get(0);
        for(i = 1; i < triangle.size(); ++i){
            for(j = triangle.get(i).size(); j > 0; --j){
                f[j] = Math.min(f[j], f[j - 1]) + triangle.get(i).get(j - 1);
            }
        }
        for(i = 1; i <= triangle.size(); ++i){
            re = Math.min(re, f[i]);
        }
        return re;
    }
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> p1 = new ArrayList<Integer>();
		ArrayList<Integer> p2 = new ArrayList<Integer>();
		p1.add(1);
		p2.add(2);
		p2.add(3);
		triangle.add(p1);
		triangle.add(p2);
		Solution sol = new Solution();
		sol.minimumTotal(triangle);
	}
}