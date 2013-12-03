/**
* Copyright ? Dec 3, 2013 
* LeetCode 9:50:33 PM
* Version 1.0
* All right reserved.
*
*/

package details.maxPoints;

import java.util.HashMap;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 9:50:33 PM
 * Version: 1.0
 */
 class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
 
public class Solution {
	public int maxPoints(Point[] points) {
        int re = 0, i, j, k, add, n = points.length;
        if(n < 3) return n;
        for(i = 0; i < n; ++i){
            HashMap<Double, Integer> m = new HashMap<Double, Integer>();
            k = 0; add = 1;
            for(j = i + 1; j < n; ++j){
                if(points[j].x == points[i].x && points[j].y == points[i].y) {
                    ++add;
                    continue;
                }
                double slope = points[j].x == points[i].x ? 
                    Double.MAX_VALUE : ((double)points[j].y - points[i].y) / (points[j].x - points[i].x);
                if(points[j].y == points[i].y) slope = 0;
                Integer cnt = m.get(slope);
                if(cnt == null) cnt = 0;
                k = Math.max(k, cnt + 1);
                m.put(slope, cnt + 1);
            }
            re = Math.max(re, k + add);
        }
        return re;
    }
	public static void main(String[] args) {
		double d1 = 3 / 9, d2 = 33 / 99;
		System.out.println(d1 == d2);
	}
}