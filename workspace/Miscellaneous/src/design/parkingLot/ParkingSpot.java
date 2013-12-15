/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 10:59:46 AM
* Version 1.0
* All right reserved.
*
*/

package design.parkingLot;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 10:59:46 AM
 * Version: 1.0
 */
public class ParkingSpot {
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;
	
	public ParkingSpot(Level lvl, int r, int n, VehicleSize s){
		this.level = lvl;
		this.row = r;
		this.spotNumber = n;
		this.spotSize = s;
		this.vehicle = null;
	}
	
	public boolean isAvailable(){
		return vehicle == null;
	}
	
	public boolean canFitVehicle(Vehicle vehicle){
		return isAvailable() && vehicle.canFitinSpot(this);
	}
	
	public boolean park(Vehicle vehicle){
		this.vehicle = vehicle;
		return true;
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getSpotNumber(){
		return this.spotNumber;
	}
	
	public VehicleSize getSize(){
		return this.spotSize;
	}
	
	public void removeVehicle(){
		this.vehicle = null;
	}

	/**
	* Method Description: 
	* Author: zd987 
	* Project Name: Miscellaneous
	* Class Name: ParkingSpot.java
	* Version: 1.0
	* Create Time: Dec 15, 2013 9:43:23 PM void
	*/
	public void print() {
		// TODO Auto-generated method stub
		if(vehicle == null){
			if(spotSize == VehicleSize.Compact){
				System.out.print("c");
			} else if(spotSize == VehicleSize.Large){
				System.out.print("l");
			} else {
				System.out.print("m");
			}
		} else {
			vehicle.print();
		}
	}
}
