/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 9:03:09 PM
* Version 1.0
* All right reserved.
*
*/

package diningPhilosophers;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 9:03:09 PM
 * Version: 1.0
 */
public class Philosopher extends Thread{
	private int id;
	private int fork1;
	private int fork2;
	private Object forks[];
	/**
	 * 
	 */
	public Philosopher(int id, int fork1, int fork2, Object[] forks) {
		this.id = id;
		this.fork1 = fork1;
		this.fork2 = fork2;
		this.forks = forks;
	}
	@Override
	public void run(){
		System.out.println("Ready to eat using forks" + fork1 + " and " + fork2);
		while(true){
			System.out.println("Picking up fork " + fork1);
			synchronized (forks[fork1]) {
				System.out.println("Picking up fork " + fork2);
				synchronized(forks[fork2]){
					System.out.println("Eating");
				}
			}
		}
	}
}
