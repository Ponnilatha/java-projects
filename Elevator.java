package org.latha.ess;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.latha.ess.cons.ElevatorMovement;
import org.latha.ess.cons.ElevatorStatus;

public class Elevator { 
	private Integer elevatorId;

private Integer currentFloor;
private Queue<Integer> destinationFloors;
Integer noOfTripsByElevator;

public Elevator(Integer currentFloor) {
  this.currentFloor = currentFloor;
  this.destinationFloors = new PriorityQueue<Integer>();
}

public int nextDestionation(){
  return this.destinationFloors.peek();
}

public int currentFloor(){
  return this.currentFloor;
}

public void popDestination(){
  this.destinationFloors.remove();
}

public void addNewDestinatoin(Integer destination) {
  this.destinationFloors.add(destination);
}

	
public void moveUp() {
  currentFloor++;
}


public void moveDown() {
  currentFloor--;
}


public ElevatorMovement direction() {
  if (destinationFloors.size() > 0){
    if (currentFloor < destinationFloors.peek()){
    	System.out.println("Elevator Moving upwards..");
      return ElevatorMovement.UP;
    } else if (currentFloor > destinationFloors.peek()) {
    	System.out.println("Elevator Moving downwards..");
      return ElevatorMovement.DOWN;
    }
  }
  return ElevatorMovement.HOLD;
}

public ElevatorStatus status() {
  return (destinationFloors.size() > 0)?ElevatorStatus.OCCUPIED:ElevatorStatus.EMPTY;
}

public Integer getElevatorId() {
	return elevatorId;
}

public void setElevatorId(Integer elevatorId) {
	this.elevatorId = elevatorId;
}

public Integer getNoOfTripsByElevator() {
	return noOfTripsByElevator;
}

public void setNoOfTripsByElevator(Integer noOfTripsByElevator) {
	this.noOfTripsByElevator = noOfTripsByElevator;
}

}
