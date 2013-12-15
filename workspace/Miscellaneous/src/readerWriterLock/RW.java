/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 8:05:15 PM
* Version 1.0
* All right reserved.
*
*/

package readerWriterLock;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 8:05:15 PM
 * Version: 1.0
 */
public class RW {
	public static Object LR = new Object();
	public static Object LW = new Object();
	public static int readCount = 0;
	public static String data = "init_data";
}
