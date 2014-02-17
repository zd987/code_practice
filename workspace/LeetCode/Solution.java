import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    private void r(ArrayList<ArrayList<Integer>> re, ArrayList<Integer> cur, int index, int[] num, int n){
        if(n == 0){
            re.add(new ArrayList<Integer>(cur));
            return;
        }
        int i, j, k;
        for(i = index; i < num.length; ++i){
            if(i != index && num[i] == num[i - 1]) continue;
            cur.add(num[i]);
            r(re, cur, i + 1, num, n - 1);
            cur.remove(cur.size() - 1);
        }
    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        re.add(cur);
        for(int i = 0; i <= num.length; ++i){
            r(re, cur, 0, num, i);
        }
        return re;
    }
}