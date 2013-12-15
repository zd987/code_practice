/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 9:27:03 PM
* Version 1.0
* All right reserved.
*
*/

package design.parkingLot;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 9:27:03 PM
 * Version: 1.0
 */
public class Car extends Vehicle{
	public Car(){
		this.spotsNeeded = 1;
		this.size = VehicleSize.Compact;
	}

	/* (non-Javadoc)
	* @see design.parkingLot.Vehicle#canFitinSpot(design.parkingLot.ParkingSpot)
	*/
	@Override
	public boolean canFitinSpot(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Compact || spot.getSize() == VehicleSize.Large;
	}

	/* (non-Javadoc)
	* @see design.parkingLot.Vehicle#print()
	*/
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("C");
	}
	
}
