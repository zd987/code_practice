/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 8:04:31 PM
* Version 1.0
* All right reserved.
*
*/

package readerWriterLock;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 8:04:31 PM
 * Version: 1.0
 */
public class Reader extends Thread{

	@Override
	public void run(){
		while(true){
			synchronized(RW.LR){
				RW.readCount++;
				RW.LR.notify();
			}
			System.out.println(RW.data);
			synchronized(RW.LR){
				RW.readCount--;
				RW.LR.notify();
			}
			// do something else..
		}
	}
}
