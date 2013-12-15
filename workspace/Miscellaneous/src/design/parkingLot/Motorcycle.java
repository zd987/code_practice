/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 9:29:05 PM
* Version 1.0
* All right reserved.
*
*/

package design.parkingLot;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 9:29:05 PM
 * Version: 1.0
 */
public class Motorcycle extends Vehicle {

	public Motorcycle(){
		this.spotsNeeded = 1;
		this.size = VehicleSize.Motocycle;
	}
	/* (non-Javadoc)
	 * @see design.parkingLot.Vehicle#canFitinSpot(design.parkingLot.ParkingSpot)
	 */
	@Override
	public boolean canFitinSpot(ParkingSpot spot) {
		return true;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("M");
	}
}
