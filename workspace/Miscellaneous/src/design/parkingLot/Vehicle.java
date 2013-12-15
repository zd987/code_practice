/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 10:59:20 AM
* Version 1.0
* All right reserved.
*
*/

package design.parkingLot;

import java.util.ArrayList;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 10:59:20 AM
 * Version: 1.0
 */
public abstract class Vehicle {
	private ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	String licensePlate;
	int spotsNeeded;
	VehicleSize size;
	
	public int getSpotsNeeded() {
		return this.spotsNeeded;
	}
	
	public VehicleSize getSize() {
		return this.size;
	}
	
	public void parkInSpot(ParkingSpot spot){
		this.parkingSpots.add(spot);
	}
	
	public void clearSpots(){
		for(ParkingSpot spot : parkingSpots){
			spot.removeVehicle();
		}
	}
	
	public abstract boolean canFitinSpot(ParkingSpot spot);

	/**
	* Method Description: 
	* Author: zd987 
	* Project Name: Miscellaneous
	* Class Name: Vehicle.java
	* Version: 1.0
	* Create Time: Dec 15, 2013 9:44:57 PM void
	*/
	public abstract void print() ;
}
