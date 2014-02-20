package homework.problem1;
/**
 * @Title: Homework Problem1
 * @Package homework.problem1
 * @Description:  
The problem description:
There are 8 slots each can hold no more than one chopstick. 
There are 7 chopsticks and only one open slot, each of the other slots has one chopstick occupied, either pointing up or down.
Initial state: uuu_nnnn -> ending state: nnnn_uuu
Each time, the chopstick you moved has to be either adjacent to the empty slot or only one chopstick away from the empty slot( it is like a small jump).
All the chopsticks on the left has to move to the right and cannot move back.
All the chopsticks on the right has to move to the left and cannot move back either.

Example of a legal but failure case:
uuu_nnnn -> uu_unnnn -> uun_unnn -> uunnu_nn -> uunnn_n -> uunnnn_ failed!

Please use program to find a solution. 
Does it have more than one solutuons? Can you have more than one algorithm?
 * 
 * @author Dong Zhao
 * @date 20140220
 * @version V1.0
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: This class is used to record the snapshot information of the transform step. 
 *
 */
class Snapshot{
	/**
	 * str is the current string of the step. for example: "uuun_nnn"
	 */
	String str; 
	
	/**
	 * moveRight use an integer to represent the flag whether the chopstick can move right or not. If the corresponding bit is 1, the chopstick can move right. Vice versa.
	 */
	int moveRight;
	
	/**
	 * openIndex is the index of the open slot.
	 */
	int openIndex;
	
	public Snapshot(String str, int moveRight, int openIndex){
		this.str = str;
		this.moveRight = moveRight;
		this.openIndex = openIndex;
	}
	
	public boolean canMoveLeft(int index){
		return (this.moveRight & (1 << index)) == 0;
	}
	
	public boolean canMoveRight(int index){
		return (this.moveRight & (1 << index)) != 0;
	}
	
	/**
	 * 
	 * @param fromIndex the index of the chopstick which will be moved from.
	 * @param toIndex the index of the open slot.
	 * @return a new snapshot after the transformed steps finished.
	 */
	public Snapshot move(int fromIndex, int toIndex){
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(toIndex, sb.charAt(fromIndex));
		sb.setCharAt(fromIndex, '_');
		int moveRight2 = moveRight;
		if((moveRight & (1 << fromIndex)) == 0){
			moveRight2 = moveRight2 & (~(1 << toIndex));
		} else {
			moveRight2 = moveRight2 | (1 << toIndex);
		}
		moveRight2 = moveRight2 & (~(1 << fromIndex));
		return new Snapshot(sb.toString(), moveRight2, fromIndex);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + openIndex;
		result = prime * result + moveRight;
		result = prime * result + ((str == null) ? 0 : str.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Snapshot other = (Snapshot) obj;
		if (openIndex != other.openIndex)
			return false;
		if (moveRight != other.moveRight)
			return false;
		if (str == null) {
			if (other.str != null)
				return false;
		} else if (!str.equals(other.str))
			return false;
		return true;
	}
	
	/**
	 * Override the toString to help the debug more easily.
	 */
	@Override
	public String toString(){
		return str + " " + this.openIndex + " " + Integer.toBinaryString(this.moveRight);
	}
}

/**
 * 
 * This class is the main class for solution.
 *
 */
public class Solution {
	/**
	 * 
	 * @param re The final result of the legal sequence
	 * @param cur The current uncompleted sequence, in reversed order.
	 * @param s the current snapshot of the step.
	 * @param m The hashmap which record the transform status, key is the to Snapshot, value is a list of from Snapshot
	 */
	private void generate(ArrayList<ArrayList<String>> re, ArrayList<String> cur, Snapshot s, HashMap<Snapshot, ArrayList<Snapshot>> m){
		ArrayList<Snapshot> list = m.get(s);
		if(list.size() == 0){
			ArrayList<String> tmp = new ArrayList<String>(cur);
			Collections.reverse(tmp);
			re.add(tmp);
			return;
		}
		for(Snapshot ss : list){
			cur.add(ss.str);
			generate(re, cur, ss, m);
			cur.remove(cur.size() - 1);
		}
	}
	
	/**
	 * 
	 * @param initStr The init state String.
	 * @param endStr The end state String.
	 * @return the result of legal sequence.
	 * Solve the problem using BFS(Breadth First Search) Graph Algorithm.
	 */
	public ArrayList<ArrayList<String>> solve(String initStr, String endStr){
		int i, j, k;
		int moveRight = 0;
		for(i = 0; i < initStr.length(); ++i){
			if(initStr.charAt(i) != '_') {
				moveRight = moveRight | (1 << i);
			} else break;
		}
		HashMap<Snapshot, ArrayList<Snapshot>> m = new HashMap<Snapshot, ArrayList<Snapshot>>();
		Queue<Snapshot> q = new LinkedList<Snapshot>();
		Snapshot initS = new Snapshot(initStr, moveRight, i);
		m.put(initS, new ArrayList<Snapshot>());
		q.offer(initS);
		int[] update = {-1, -2, +1, +2};
		while(!q.isEmpty()){
			Snapshot s = q.poll();
			for(i = 0; i < update.length; ++i){
				if( s.openIndex + update[i] >= 0 && s.openIndex + update[i] < s.str.length() && 
					( (update[i] < 0 && s.canMoveRight(s.openIndex + update[i])) || 
					  (update[i] > 0 && s.canMoveLeft(s.openIndex + update[i])) )
				   ){
					Snapshot s2 = s.move(s.openIndex + update[i], s.openIndex);
					ArrayList<Snapshot> list = m.get(s2);
					if(list == null) {
						list = new ArrayList<Snapshot>();
						m.put(s2, list);
						if(!s2.str.equals(endStr)) {
							q.offer(s2);
						}
					}
					list.add(s);
				}
			}
		}
		int moveRight2 = 0;
		for(j = endStr.length() - 1; j >= 0; --j){
			if(endStr.charAt(j) != '_') {
				moveRight2 = moveRight2 | (1 << j);
			} else break;
		}
		Snapshot endS = new Snapshot(endStr, moveRight2, j);
		ArrayList<ArrayList<String>> re = new ArrayList<ArrayList<String>>();
		ArrayList<String> cur = new ArrayList<String>();
		cur.add(endS.str);
		generate(re, cur, endS, m);		
		return re;
	}
	
	/**
	 * Output the test result into console.
	 * @param initStr
	 * @param endStr
	 */
	public void test(String initStr, String endStr){
		ArrayList<ArrayList<String>> re = solve(initStr, endStr);
		int cnt = 1;
		for(ArrayList<String> list : re){
			System.out.println("Solution " + cnt + ": " + list);
			++cnt;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
			Solution sol = new Solution();
			sol.test("u_n", "n_u");
			/*
			Solution 1: [u_n, _un, nu_, n_u]
			Solution 2: [u_n, un_, _nu, n_u]
			 */
			
			sol.test("u_nn", "nn_u");
			/*
			Solution 1: [u_nn, _unn, nu_n, n_un, nnu_, nn_u]
			Solution 2: [u_nn, un_n, _nun, n_un, nnu_, nn_u]
			Solution 3: [u_nn, _unn, nu_n, nun_, n_nu, nn_u]
			 */
			
			sol.test("uu_nn", "nn_uu");
			/*
			Solution 1: [uu_nn, u_unn, unu_n, unun_, un_nu, _nunu, n_unu, nnu_u, nn_uu]
			Solution 2: [uu_nn, uun_n, u_nun, _unun, nu_un, nunu_, nun_u, n_nuu, nn_uu]
			 */
			
			sol.test("uuu_nnnn", "nnnn_uuu");
			/*
			Solution 1: [uuu_nnnn, uu_unnnn, uunu_nnn, uunun_nn, uun_nunn, u_nununn, _unununn, nu_ununn, nunu_unn, nununu_n, nununun_, nunun_nu, nun_nunu, n_nununu, nn_ununu, nnnu_unu, nnnunu_u, nnnun_uu, nnn_nuuu, nnnn_uuu]
			Solution 2: [uuu_nnnn, uuun_nnn, uu_nunnn, u_ununnn, unu_unnn, ununu_nn, ununun_n, unun_nun, un_nunun, _nununun, n_ununun, nnu_unun, nnunu_un, nnununu_, nnunun_u, nnun_nuu, nn_nunuu, nnn_unuu, nnnnu_uu, nnnn_uuu]
			 */
	}
}
