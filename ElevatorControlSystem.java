/**
 * 
 */
package org.latha.ess;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with Eclipse Mars1
 * @author latha
 * Date: 02/23/2016
 *
 */
public class ElevatorControlSystem {
	public static final int MAXNO_OF_ELEVATORS = 10;
	Integer numberOfElevators = 0;
	Integer numberOfFloors = 0;
	List elevators;
	Queue<Integer> pickupfloors;
	
	public ElevatorControlSystem(Integer numberOfElevators, Integer numberOfFloors){
		 this.numberOfElevators = (numberOfElevators > MAXNO_OF_ELEVATORS)?MAXNO_OF_ELEVATORS:numberOfElevators;
		 this.numberOfFloors = numberOfFloors;
		 pickupfloors = new PriorityQueue<Integer>();
		 
	}
}
