/**
* Copyright ? Dec 5, 2013 
* LeetCode 7:32:37 AM
* Version 1.0
* All right reserved.
*
*/

package string.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Class Description:
 * Author: zd987
 * Project Name: LeetCode
 * Create Time: Dec 5, 2013 7:32:37 AM
 * Version: 1.0
 */
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> re = new ArrayList<String>();
        HashMap<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();
        int i, j, k, n = strs.length;
        for(i = 0; i < n; ++i){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            ArrayList<String> list = m.get(sorted);
            if(list == null) {
            	list = new ArrayList<String>();
            	m.put(sorted, list);
            }
            list.add(strs[i]);
        }
        for(ArrayList<String> list : m.values()){
        	if(list.size() > 1) re.addAll(list);
        }
        return re;
    }
}