/**
* Copyright ? Dec 3, 2013 
* LeetCode 6:22:33 AM
* Version 1.0
* All right reserved.
*
*/

package details.insert;

import java.util.ArrayList;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 6:22:33 AM
 * Version: 1.0
 */
 class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

 public class Solution {
	    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	        ArrayList<Interval> re = new ArrayList<Interval>();
	        int i, j, k, start = newInterval.start, end = newInterval.end;
	        boolean added = false;
	        for(Interval it : intervals){
	            if(it.end < start) {
	                re.add(it);
	                continue;
	            } 
	            if(it.start > end) {
	                if(!added) {
	                    re.add(new Interval(start, end)); 
	                    added = true;
	                }
	                re.add(it);
	                continue;
	            }
	            start = Math.min(it.start, start);
	            end = Math.max(it.end, end);
	        }
	        if(!added){
	            re.add(new Interval(start, end)); 
	        }
	        return re;
	    }
	}