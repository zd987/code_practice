/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 8:35:52 PM
* Version 1.0
* All right reserved.
*
*/

package producerConsumer;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 8:35:52 PM
 * Version: 1.0
 */
public class Consumer extends Thread {
	private IntBuffer buffer;
	public Consumer(IntBuffer buffer){
		this.buffer = buffer;
	}
	@Override
	public void run(){
		while(true){
			int num = buffer.remove();
			System.out.println("Consumed " + num);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
