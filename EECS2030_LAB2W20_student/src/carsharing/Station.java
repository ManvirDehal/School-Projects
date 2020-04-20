package carsharing;

import java.util.ArrayList;

public class Station {
	int stationNumber;
	ArrayList<Passenger> people = new ArrayList<Passenger>();
	
	public Station (int number) {
		
	}
	
	public int getNumber() {
		return stationNumber;
	}
	
	void add(Passenger p) { //adds passenger
		
	}
	
	Passenger get(int index) {
		return null;
	}
	
	Passenger remove(int index) {
		return null;
	}
	
	ArrayList<Passenger> peopleWaitingList(){
		return people;
	}
	
	public String toString() {
		return "";
	}
}
