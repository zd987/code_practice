/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 8:08:16 PM
* Version 1.0
* All right reserved.
*
*/

package readerWriterLock;

import java.util.Date;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 8:08:16 PM
 * Version: 1.0
 */
public class Writer extends Thread{

	@Override
	public void run(){
		while(true){
			synchronized(RW.LW){
				boolean done = false;
				while(!done){
					synchronized(RW.LR){
						if(RW.readCount == 0){
							RW.data = new Date().toString();
							done = true;
						} else {
							// try wait / notify to avoid busy waiting
							try {
								RW.LR.wait();
							} catch (InterruptedException e) {
								System.out.println("InterruptedException in Writer wait");
							}
						}
						RW.LR.notify();
					}
				}
			}
			// task do something else...
		}
	}
}
