package qual;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A {

	public static boolean  check(String[] m, int n){
		int i, j, x = -1, y = -1, cnt = 0;
		for(i = 0; i < n; ++i){
			for(j = 0; j < n; ++j){
				if(m[i].charAt(j) == '#') {
					if(x == -1){
						x = i;
						y = j;
					}
					++cnt;
				}
			}
		}
		if(x == -1) return false;
		for(i = y + 1; i < n; ++i){
			if(m[x].charAt(i) != '#') break;
		}
		int len = i - y;
		if(y + len > n) return false;
		if(cnt != len * len) return false;
		for(i = x + 1; i < x + len; ++i){
			for(j = y; j < y + len; ++j){
				if(m[i].charAt(j) != '#') return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner cin = new Scanner(new FileInputStream("E:/test/square_detector.txt")); 
		int T = cin.nextInt();
		for(int i = 1; i <= T; ++i){
			int N = cin.nextInt();
			cin.nextLine();
			String[] m = new String[N];
			for(int j = 0; j < N; ++j){
				m[j] = cin.nextLine();
			}
			System.out.print("Case #" + i + ": ");
			System.out.println(check(m, N) ? "YES" : "NO");
		}
	}

}
