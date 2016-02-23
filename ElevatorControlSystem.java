/**
 * 
 */
package org.latha.ess;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.latha.ess.cons.ElevatorMovement;
import org.latha.ess.exception.InvalidNoOfElevator;

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
	List<Elevator> elevators;
	Queue<Integer> pickupfloors;
	
	public ElevatorControlSystem(Integer numberOfElevators, Integer numberOfFloors) throws InvalidNoOfElevator{
		 if (numberOfElevators < 0) throw new InvalidNoOfElevator("Elevator numbers must be atleast 1 to 10");
		 this.numberOfElevators = (numberOfElevators > MAXNO_OF_ELEVATORS)?MAXNO_OF_ELEVATORS:numberOfElevators;
		 this.numberOfFloors = numberOfFloors;
		 initializeElevators();
		 pickupfloors = new PriorityQueue<Integer>();
		 
	}
	
	private void initializeElevators(){
	    elevators = new ArrayList<Elevator>();
	    for (int idx=0;idx<this.numberOfElevators;idx++){
	      elevators.add(new Elevator(1));
	    }
	  }

	  public List<Elevator> getElevators(){
	    return elevators;
	  }

	  
	  public void pickUp(Integer pickUpFloor) {
		  pickupfloors.add(pickUpFloor);
	  }

	  
	  public void destination(Integer elevatorId, Integer destinationFloor) {
	    elevators.get(elevatorId).addNewDestinatoin(destinationFloor);
	  }

	  
	  public void step() {
	    // Loop though every elevator
	    for (Elevator currElevator : elevators){
	      // Check to figure out which ones are unoccupied and update call
	      switch (currElevator.status()){
	        case EMPTY:
	          if (!pickupfloors.isEmpty()){
	        	  System.out.println("Opening the Elevator "+currElevator.currentFloor());
	            currElevator.addNewDestinatoin(pickupfloors.poll());
	            System.out.println("Closing the Elevator "+currElevator.currentFloor());
	          }
	          break;
	        // Move occupied Elevators one step closer to next closest destination in direction
	        case OCCUPIED:
	          switch (currElevator.direction()){
	            case UP:
	              currElevator.moveUp();
	              break;
	            case DOWN:
	              currElevator.moveDown();
	              break;
	            case HOLD:
	              // TODO: Check timer here to alert users that they are holding the door open to long
	              // TODO: Emergency situation where elevator can't be used
	              // TODO: Maintenance Mode e.g. movers or maintenance people
	              currElevator.popDestination();
	              break;
	          }
	          if (currElevator.direction() == ElevatorMovement.UP)
	          break;
	      }
	    }
	  }
}
