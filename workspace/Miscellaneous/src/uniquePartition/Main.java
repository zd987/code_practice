package uniquePartition;

import java.util.ArrayList;

//http://www.geeksforgeeks.org/generate-unique-partitions-of-an-integer/
public class Main {
	private void helper(int max, int left, ArrayList<Integer> cur){
		if(left == 0){
			for(Integer ii : cur){
				System.out.print(ii + " ");
			}
			System.out.println();
			return;
		}
		int i, j, k = Math.min(max, left);
		for(i = k; i >= 1; --i){
			cur.add(i);
			helper(i, left - i, cur);
			cur.remove(cur.size() - 1);
		}
	}
	
	public void uniquePartiotion(int n){
		ArrayList<Integer> cur = new ArrayList<Integer>();
		helper(n, n, cur);
	}
	public static void main(String[] args) {
		Main m = new Main();
		m.uniquePartiotion(5);
	}
}
