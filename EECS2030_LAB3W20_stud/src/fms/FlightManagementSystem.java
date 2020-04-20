package fms;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


@SuppressWarnings("unused")
public class FlightManagementSystem extends java.lang.Object {
	
	/*
	 * Each entry in a 'passengers' map contains
	 * a unique  ID (this is different from the flightID defined in the passenger class), and its associated information object.
	 */
	HashMap<String, PassengerInfo> passengers = new HashMap<>();

	/*
	 * Each entry in a 'flights' map contains
	 * a unique id (this is different from the flightID defined in the passenger class) and its associated information object.
	 */
	HashMap<Integer, FlightInfo> flights = new HashMap<>();

	/**
	 * Initialize an empty database.
	 */
	public FlightManagementSystem() {
		passengers.clear();
		flights.clear();
	}

	/**
	 * Add a new passenger entry.
	 * @param id - id of the passenger
	 * @param info - information object of the  passenger
	 * @throws IdAlreadyExistsExceptoin if 'id' is an existing passenger id
	 */
	public void addPassenger(String id, PassengerInfo info) throws IdAlreadyExistsExceptoin {
		if(passengers.containsKey(id))
		{
			//System.out.println("Nope");
			throw new IdAlreadyExistsExceptoin("");
		}
		else {
			passengers.put(id, info);
		}
	}

	/**
	 * Remove an existing passenger entry.
	 * @param id - id of the passenger
	 * @throws IdNotFoundException if 'id' is not an existing passenger id
	 */
	public void removePassenger(String id) throws IdNotFoundException {
		if(passengers.containsKey(id))
		{			
			passengers.remove(id);
		}
		else throw new IdNotFoundException("");
	}

	
	
	
	/**
	 * Add a new flight entry.
	 * @param id id of the flight
	 * @param info information object of the flight
	 * @throws IdAlreadyExistsExceptoin if 'id' is an existing flight id
	 */
	public void addFlight(Integer id, FlightInfo info) throws IdAlreadyExistsExceptoin {
		if(flights.containsKey(id))
		{
			throw new IdAlreadyExistsExceptoin("");
		}
		else flights.put(id, info);
	}

	/**
	 * Remove an existing flight entry.
	 * @param id id of some flight
	 * @throws IdNotFoundException if 'id' is not an existing flight
	 */
	public void removeFlight(Integer id) throws IdNotFoundException {
		if(flights.containsKey(id)){
			flights.remove(id);
		}
		else throw new IdNotFoundException("");
	}

	
	
	/**
	 * Change the flight of passenger with id 'eid' to a new flight with id 'did'.
	 * 
	 * You can assume that 'did' denotes a flight different from
	 * the current flight of the passenger denoted by 'eid'.
	 * @param eid id of some passenger
	 * @param did id of some flight
	 * @throws IdNotFoundException if either eid is a non-existing passenger id or did is a non-existing flight id.
	 */
	public void changeFlight(String eid, Integer did) throws IdNotFoundException {
		Set<String> keysett = passengers.keySet();
		ArrayList<String> listt = new ArrayList<String>();
		ArrayList<Integer> intList = new ArrayList<Integer>();
		listt.addAll(keysett);
		for(int x = 0; x < keysett.size(); x++)
		{
			intList.add(passengers.get(listt.get(x)).FlightID);
		}
		if(listt.contains(eid) && intList.contains(did))
		{
			passengers.get(eid).setFlightId(did);
		}
		else throw new IdNotFoundException("");
	}

	/**
	 * Retrieve the name of passenger with id 'id'.
	 * @param id id of some passenger
	 * @return name of the passenger with id 'id'
	 * @throws IdNotFoundException if 'id' is not an existing passenger id
	 */
	public String getPassengerName(String id) throws IdNotFoundException {
		String name = "";
		if(passengers.containsKey(id))
		{
			name = passengers.get(id).getName();
		}
		else throw new IdNotFoundException("");
		return name;
	}

	/**
	 * Retrieve the names of all passengers of the flight with id 'id'.
	 * If 'id' is a non-existing flight id, then return an empty list.
	 * @param id id of some flight
	 * @return List of names of passengers whose flight has id 'id'
	 */
	public ArrayList<String> getPassengerNames(Integer id) {
		Set<String> keyset = passengers.keySet();
		ArrayList<String> b = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		list.addAll(keyset);
		for(int x = 0; x < keyset.size(); x++)
		{
			if(passengers.get(list.get(x)).FlightID == id) {
				b.add(passengers.get(list.get(x)).name);
			}
		}
		return b;
	}

	/**
	 * Retrieve passengers flight information object.  
	 * @param id id of some passenger
	 * @return The information object of the passengers flight
	 * @throws IdNotFoundException if 'id' is not an existing passenger id
	 */
	public FlightInfo getFlightInfo(String id) throws IdNotFoundException {
		
		if(passengers.containsKey(id))
		{
			Integer fID = passengers.get(id).FlightID;
			String airline = flights.get(fID).getairline();
			String name = flights.get(fID).getName();
			FlightInfo d = new FlightInfo(name,airline);
			return d;
		}
		else throw new IdNotFoundException("");
	}

	/**
	 * Retrieve a list, sorted in increasing order, 
	 * the information objects of all stored passengers.
	 * 
	 * Hints: 
	 * 1. Override the 'compareTo' method in PassengerInfo class. 
	 * 2. Look up the Arrays.sort method in Java API. 
	 * @return A sorted list of information objects of all passengers.
	 */
	public PassengerInfo[] getSortedPassengerInfo() {
		Set<String> keys = passengers.keySet();
		ArrayList<String> nameKeys = new ArrayList<String>();
		nameKeys.addAll(keys);
		
		PassengerInfo[] p = new PassengerInfo[nameKeys.size()];
		for(int x = 0; x < nameKeys.size(); x++)
		{			
			p[x] =  new PassengerInfo(passengers.get(nameKeys.get(x)).name	, passengers.get(nameKeys.get(x)).TicketAmount, passengers.get(nameKeys.get(x)).FlightID);
		}
		
		Arrays.sort(p);
		return p;
	}

	/**
	 * Retrieve the average ticket paid by all passengers in flight with id 'id'.
	 * @param id id of some flight
	 * @return average ticket paid by all passengers in a flight with id 'id'
	 * @throws IdNotFoundException if id is not an existing flight id
	 */
	public double getAverageTicketAmount(Integer id) throws IdNotFoundException {
		Set<String> keys = passengers.keySet();
		ArrayList <String> list = new ArrayList<String>();
		ArrayList <Integer> intList = new ArrayList <Integer>();
		list.addAll(keys);
		int count = 0;
		double price = 0;
		for(int x = 0; x < keys.size(); x++)
		{			
			intList.add(passengers.get(list.get(x)).FlightID);
		}
		if(intList.contains(id)){
			for(int y = 0; y < keys.size();y++)
			{				
				if(intList.get(y).equals(id))
				{
					price += passengers.get(list.get(y)).getTicketAmount();
					count++;
				}
			}
		}
		else throw new IdNotFoundException("");
		return price/count;
	}

	
	
}