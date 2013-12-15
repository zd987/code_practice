/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 8:54:54 PM
* Version 1.0
* All right reserved.
*
*/

package producerConsumer;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 8:54:54 PM
 * Version: 1.0
 */
public class MySemaphore {
	private int counter;
	public synchronized void accquire() throws InterruptedException{
		while(counter == 1){
			wait();
		}
		counter++;
	}
	public synchronized void release(){
		counter--;
		notifyAll();
	}
}
