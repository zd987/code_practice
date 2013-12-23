package dp;

public class MaximumProductCutting {
	public int solve(int n){
		int i, j, k, t;
		int[] f = new int[n + 1];
		f[1] = 1;
		for(i = 2; i <= n; ++i){
			f[i] = i - 1;
			for(j = i - 1; j >= 1; --j){
				k = Math.max((i - j) * j, (i - j) * f[j]);
				f[i] = Math.max(f[i], k);
			}
		}
		return f[n];
	}
	public static void main(String[] args) {
		MaximumProductCutting m = new MaximumProductCutting();
		System.out.println(m.solve(10));
	}
}
