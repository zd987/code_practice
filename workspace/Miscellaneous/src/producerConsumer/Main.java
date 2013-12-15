/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 8:46:57 PM
* Version 1.0
* All right reserved.
*
*/

package producerConsumer;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 8:46:57 PM
 * Version: 1.0
 */
public class Main {
	public static void main(String[] args) {
		IntBuffer b = new IntBuffer();
		Producer p = new Producer( b );
		Consumer c = new Consumer( b );
		p.start();
		c.start();
	}
}
