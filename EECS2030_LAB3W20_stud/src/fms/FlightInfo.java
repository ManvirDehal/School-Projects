package fms;

public class FlightInfo extends java.lang.Object {
	java.lang.String name, airline;
	public FlightInfo(java.lang.String name, java.lang.String airline)
	{
		this.name = name;
		this.airline = airline;
	}
	
	public java.lang.String getName(){
		return name;
	}
	
	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public java.lang.String getairline(){ //Possible method problem
		return airline;
	}
	
	public void setairline(java.lang.String airline) {
		this.airline = airline;
	}
	
	public boolean equals(java.lang.Object obj) { //Change this
		if(this.getClass() == obj.getClass())
		{
			return true;
		}
		else return false;
	}
}