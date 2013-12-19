
package recursivePrint;

public class Main {
	public static final int N = 8;
	public static void rp(int row, int col){
		if(col > 0){
			System.out.print("*");
			rp(row, col - 1);
		} else {
			System.out.println();
			++row;
			if(row == N) return;
			rp(row, N - row);
		}
	}
	public static void main(String[] args) {
		rp(0, 8);
	}
}
