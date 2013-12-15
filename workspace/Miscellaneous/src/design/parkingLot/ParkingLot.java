/**
* Copyright ? Dec 15, 2013 
* Miscellaneous 11:55:03 AM
* Version 1.0
* All right reserved.
*
*/

package design.parkingLot;

/**
 * Class Description:
 * Author: zd987
 * Project Name: Miscellaneous
 * Create Time: Dec 15, 2013 11:55:03 AM
 * Version: 1.0
 */
public class ParkingLot {
	private Level[] levels;
	private final int NUM_LEVELS = 5;
	public ParkingLot(){
		levels = new Level[NUM_LEVELS];
		for(int i = 0; i < NUM_LEVELS; ++i){
			levels[i] = new Level(i, 30);
		}
	}
	public boolean parkVehicle(Vehicle vehicle){
		for(Level level : levels){
			if(level.parkVehicle(vehicle)){
				return true;
			}
		}
		return false;
	}
	public void print(){
		for(int i = 0; i < levels.length; ++i){
			System.out.println("Level " + i + ": ");
			levels[i].print();
			System.out.println("");
		}
		System.out.println("");
	}
}
