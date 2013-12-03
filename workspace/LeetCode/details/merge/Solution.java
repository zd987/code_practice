/**
* Copyright ? Dec 3, 2013 
* LeetCode 6:45:02 AM
* Version 1.0
* All right reserved.
*
*/

package details.merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 3, 2013 6:45:02 AM
 * Version: 1.0
 */
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        ArrayList<Interval> re = new ArrayList<Interval>();
        int i, j, k;
        Interval cur = null;
        for(Interval it : intervals){
            if(cur == null) {
                cur = it;
            } else if(it.start > cur.end){
                re.add(cur);
                cur = it;
            } else {
                cur.end = Math.max(cur.end, it.end);
            }
        }
        if(cur != null) re.add(cur);
        return re;
    }
}