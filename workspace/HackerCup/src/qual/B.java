package qual;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
class Player{
	String name;
	int shot, height;
	int rank = -1;
	int playTime = 0, benchTime = 0;
	public Player(String name, int shot, int height){
		this.name = name;
		this.shot = shot;
		this.height = height;
	}
	
	@Override
	public String toString(){
		return name;
	}
}
class RankComparator implements Comparator<Player>{
	@Override
	public int compare(Player o1, Player o2) {
		if(o1.shot == o2.shot){
			return o2.height - o1.height; 
		}
		return o2.shot - o1.shot;
	}	
}
class PlayComparator implements Comparator<Player>{
	@Override
	public int compare(Player o1, Player o2) {
		if(o1.benchTime == o2.benchTime){
			return o2.rank - o1.rank;
		}
		return o1.benchTime - o2.benchTime;
	}	
}
class BenchComparator implements Comparator<Player>{
	@Override
	public int compare(Player o1, Player o2) {
		if(o1.playTime == o2.playTime){
			return o1.rank - o2.rank;
		}
		return o1.playTime - o2.playTime;
	}	
}
public class B {

	public static void sol(ArrayList<Player> list, int N, int M, int P){
		Collections.sort(list, new RankComparator());
		int i, j, k;
		boolean odd = true;
		ArrayList<Player> team1 = new ArrayList<Player>();
		ArrayList<Player> team2 = new ArrayList<Player>();
		for(i = 0; i < N; ++i){
			Player p = list.get(i);
			p.rank = i + 1;
			if(odd){
				team1.add(p);
			} else {
				team2.add(p);
			}
			odd = !odd;
		}
		PriorityQueue<Player> play1 = new PriorityQueue<Player>(P, new PlayComparator());
		PriorityQueue<Player> bench1 = new PriorityQueue<Player>(P, new BenchComparator());
		PriorityQueue<Player> play2 = new PriorityQueue<Player>(P, new PlayComparator());
		PriorityQueue<Player> bench2 = new PriorityQueue<Player>(P, new BenchComparator());
		for(i = 0; i < P; ++i){
			play1.add(team1.get(i));
			play2.add(team2.get(i));
		}
		for(i = P; i < team1.size(); ++i){
			bench1.add(team1.get(i));
		}
		for(i = P; i < team2.size(); ++i){
			bench2.add(team2.get(i));
		}
		for(i = 1; i <= M; ++i){
			Player off, on;
			if(!bench1.isEmpty()){
				on = bench1.poll();
				off = play1.poll();
				on.benchTime = i - on.playTime;
				off.playTime = i - off.benchTime;
				bench1.offer(off);
				play1.offer(on);
			}
			if(!bench2.isEmpty()){
				on = bench2.poll();
				off = play2.poll();
				on.benchTime = i - on.playTime;
				off.playTime = i - off.benchTime;
				bench2.offer(off);
				play2.offer(on);
			}
		}
		ArrayList<String> names = new ArrayList<String>();
		while(!play1.isEmpty()) {
			names.add(play1.poll().name);
		}
		while(!play2.isEmpty()) {
			names.add(play2.poll().name);
		}
		Collections.sort(names);
		for(String name : names){
			System.out.print(" " + name);
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String input = "E:/test/basketball_game.txt";
		Scanner cin = new Scanner(new FileInputStream(input)); 
		int T = cin.nextInt(), N, M, P;
		for(int t = 1; t <= T; ++t){
			N = cin.nextInt();
			M = cin.nextInt();
			P = cin.nextInt();
			ArrayList<Player> list = new ArrayList<Player>();
			for(int i = 0; i < N; ++i){
				String name = cin.next();
				int shot = cin.nextInt();
				int height = cin.nextInt();
				Player p = new Player(name, shot, height);
				list.add(p);
			}
			System.out.print("Case #" + t + ":");
			sol(list, N, M, P);
		}
	}

}
