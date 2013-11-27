/**
* Copyright ? Nov 27, 2013 
* Miscellaneous 7:42:21 PM
* Version 1.0
* All right reserved.
*
*/

package maxMsum;
//http://acm.hdu.edu.cn/showproblem.php?pid=1024
//http://www.cnblogs.com/kuangbin/archive/2011/08/04/2127085.html
/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Nov 27, 2013 7:42:21 PM
 * Version: 1.0
 */
import java.io.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws IOException
    {
    	System.setIn(new FileInputStream("E:/input.txt"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int m, n, i, j, k;
        long max = 0, t;
        int[] s = new int[1000005];
        long[] f = new long[1000005];
        long[] g = new long[1000005];
        while(in.nextToken() != StreamTokenizer.TT_EOF)
        {
            m = (int)in.nval;
            in.nextToken();
            n = (int)in.nval;
            f[0] = 0; g[0] = 0;
            for(i = 1; i <= n; ++i){
                in.nextToken();
            	s[i] = (int)in.nval;
            	g[i] = 0;
            	f[i] = 0;
            }
            for(i = 1; i <= m; ++i){
            	max = Integer.MIN_VALUE;
            	for(j = i; j <= n; ++j){
            		f[j] = Math.max(f[j - 1], g[j - 1]) + s[j];
            		g[j - 1] = max;
            		max = Math.max(max, f[j]);
            	}
            }
            out.println(max);
        }
        out.flush();
    }
}