/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 8:34:22 PM
* Version 1.0
* All right reserved.
*
*/

package producerConsumer;

import java.util.Random;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 8:34:22 PM
 * Version: 1.0
 */
public class Producer extends Thread {
	private IntBuffer buffer;
	public Producer(IntBuffer buffer){
		this.buffer = buffer;
	}
	@Override
	public void run(){
		Random r = new Random();
		while(true){
			int num = r.nextInt();
			buffer.add(num);
			System.out.println("Produced " + num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
