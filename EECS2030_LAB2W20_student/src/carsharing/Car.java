package carsharing;

import java.util.ArrayList;

public class Car {
	int idNo, destination, location;
	ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	double faresCollected, FAREPERMILE = 1.0;
	int milesDriven, MAXPASSENGERS = 3;
	
	public Car(int idNo, int destination, int location)
	{
		this.idNo = idNo;
		this.destination = destination;
		this.location = location;
	}

	public int getIdNo() {
		return idNo;
	}

	public int getDestination() {
		return destination;
	}

	public int getLocation() {
		return location;
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public double getFares() {
		return faresCollected;
	}

	public int getMilesDriven() {
		return milesDriven;
	}
	
	public boolean hasArrived() {
		if(location == destination)
		{
			return true;
		}
		else return false;
	}
	
	public boolean hasRoom() {
		if(passengers.size() < MAXPASSENGERS)
		{
			return true;
		}
		else return false;
	}
	
	public void drive() {
		if(hasArrived() != true)
		{
			
		}
		
		System.out.println("Car X drives to station Y");
	}
	
	public boolean dropOff() {
		if(hasArrived()) {
			return true;
		}
		else return false;
	}
	
	public boolean add(Passenger p) {
		if(hasRoom()) {
			return true;
		}
		else return false;
	}
	
	public String toString() {
		return "";//Change this later
	}
}
