/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 11:27:17 AM
* Version 1.0
* All right reserved.
*
*/

package design.parkingLot;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 11:27:17 AM
 * Version: 1.0
 */
public class Bus extends Vehicle {

	public Bus(){
		this.spotsNeeded = 5;
		this.size = VehicleSize.Large;
	}
	/* (non-Javadoc)
	 * @see design.parkingLot.Vehicle#canFitinSpot(design.parkingLot.ParkingSpot)
	 */
	@Override
	public boolean canFitinSpot(ParkingSpot spot) {
		return spot.getSize() == this.size;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("B");
	}
}
