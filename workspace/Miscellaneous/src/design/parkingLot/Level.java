/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 11:05:14 AM
* Version 1.0
* All right reserved.
*
*/

package design.parkingLot;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 11:05:14 AM
 * Version: 1.0
 */
public class Level {
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0;
	private static final int SPOTS_PER_ROW = 10;
	public Level(int floor, int avail){
		this.floor = floor;
		spots = new ParkingSpot[avail];
		int largeSpots = avail / 4;
		int bikeSpots = avail / 4;
		int compactSpots = avail - largeSpots - bikeSpots;
		for(int i = 0; i < avail; ++i){
			VehicleSize sz = VehicleSize.Motocycle;
			if(i < largeSpots){
				sz = VehicleSize.Large;
			} else if(i < largeSpots + compactSpots){
				sz = VehicleSize.Compact;
			}
			int row = i / SPOTS_PER_ROW;
			spots[i] = new ParkingSpot(this, row, i, sz);
		}
		availableSpots = avail;
	}
	public int availableSpots() {
		return this.availableSpots;
	}
	public boolean parkVehicle(Vehicle vehicle){
		if(this.availableSpots() < vehicle.getSpotsNeeded()) return false;
		int spotNumber = this.findAvailableSpots(vehicle);
		if(spotNumber < 0) return false;
		return parkVehicle(spotNumber, vehicle);
	}
	
	private boolean parkVehicle(int spotNumber, Vehicle v){
		v.clearSpots();
		boolean success = true;
		for(int i = spotNumber; i < spotNumber + v.getSpotsNeeded(); ++i){
			success &= spots[i].park(v);
		}
		availableSpots -= v.getSpotsNeeded();
		return true;
	}
	
	private int findAvailableSpots(Vehicle v){
		int spotsNeeded = v.getSpotsNeeded();
		int lastRow = -1;
		int spotsFound = 0;
		for(int i = 0; i < spots.length; ++i){
			ParkingSpot spot = spots[i];
			if(lastRow != spot.getRow()){
				spotsFound = 0;
				lastRow = spot.getRow();
			}
			if(spot.canFitVehicle(v)){
				spotsFound++;
			} else {
				spotsFound = 0;
			}
			if(spotsFound == spotsNeeded){
				return i - (spotsNeeded - 1);
			}
		}
		return -1;
	}
	public void sportFreed(){
		this.availableSpots++;
	}
	public void print(){
		int lastRow = -1;
		for(int i = 0; i < spots.length; ++i){
			ParkingSpot spot = spots[i];
			if(spot.getRow() != lastRow){
				System.out.print(" ");
				lastRow = spot.getRow();
			}
			spot.print();
		}
	}
}
