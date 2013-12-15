/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 8:22:35 PM
* Version 1.0
* All right reserved.
*
*/

package producerConsumer;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 8:22:35 PM
 * Version: 1.0
 */
public class IntBuffer {
	private int index;
	private int[] buffer = new int[8];
	public synchronized void add(int num){
		while(index == buffer.length - 1){			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		buffer[index++] = num;
		notifyAll();
	}
	public synchronized int remove(){
		while(index == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int ret = buffer[--index];
		notifyAll();
		return ret;
	}
}
