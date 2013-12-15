/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 9:02:35 PM
* Version 1.0
* All right reserved.
*
*/

package diningPhilosophers;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 9:02:35 PM
 * Version: 1.0
 */
public class DiningPhilosophers {
	private Object[] forks;
	private Philosopher[] philosophers;
	private DiningPhilosophers(int num){
		forks = new Object[num];
		philosophers = new Philosopher[num];
		for(int i = 0; i < num; ++i){
			forks[i] = new Object();
			int fork1 = i;
			int fork2 = (i + 1) % num;
			if((i % 2) == 0) {
				philosophers[i] = new Philosopher(i, fork2, fork1, forks);	
			} else {
				philosophers[i] = new Philosopher(i, fork1, fork2, forks);	
			}
		}
	}
	public void startEating() throws InterruptedException {
		for(int i = 0; i < philosophers.length; ++i){
			philosophers[i].start();
		}
		philosophers[0].join();
	}
	public static void main(String[] args) {
		DiningPhilosophers d = new DiningPhilosophers(5);
		try {
			d.startEating();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
