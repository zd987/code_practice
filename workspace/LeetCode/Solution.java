public class Solution {
    public int minCut(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i, j, k, n = s.length();
        int[] f = new int[n];
        boolean[][] p = new boolean[n][n];
        for(i = 0; i < n; ++i){
            f[i] = i + 1;
        }
        for(i = 0; i < n; ++i){
            for(j = 0; j < i; ++j){
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || p[j + 1][i - 1])){
                    p[j][i] = true;
                    f[i] = j == 0 ? 1 : Math.max(f[i], f[j - 1] + 1);
                }
            }
        }
        return f[n - 1];
    }
}