package bookStore;

public class BookStoreOwner extends java.lang.Object{
	String name;
	long id;
	public BookStoreOwner(java.lang.String name)
	{
		this.name = name;
		this.id = 1;
	}
	
	public long getID() {
		return this.id;
	}
	
	public java.lang.String getName(){
		return name;
	}
	
	public int hashCode() {
		return this.hashCode();
	}
	
	public boolean equals(java.lang.Object obj) {
		if(obj.getClass() == this.getClass())
		{
			return true;
		}
		else return false;
	}
	
	public java.lang.String toString(){
		return name + " " + id;
	}
}
