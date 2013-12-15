/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 9:48:59 PM
* Version 1.0
* All right reserved.
*
*/

package design.parkingLot;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 9:48:59 PM
 * Version: 1.0
 */
public class Question {
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	public static void main(String[] args) {
		ParkingLot lot = new ParkingLot();
		Vehicle v = null;
		while(v == null || lot.parkVehicle(v)){
			lot.print();
			int r = randomIntInRange(0, 10);
			if(r < 2){
				v = new Bus();
			} else if(r < 4){
				v = new Motorcycle();
			} else {
				v = new Car();
			}
			System.out.print("\nParking s ");
			v.print();
			System.out.println("");
		}
		System.out.println("Parking Failed. Final state: ");
		lot.print();
	}
}
