package bookStore;

public class Book extends java.lang.Object implements java.lang.Comparable<Book>{
	double price;
	int yearPublished;
	String title;
	public Book() {
		this.price = 0;
		this.yearPublished = 0;
		this.title = "";
	}
	
	public Book(Book book) {
		this.price = book.price;
		this.title = book.title;
		this.yearPublished = book.yearPublished;
	}
	
	public Book(java.lang.String title, int yearPublished, double price) {
		this.title = title;
		this.yearPublished = yearPublished;
		this.price = price;
	}
	
	public int getyearPublished() {
		return yearPublished;
	}
	
	public java.lang.String gettitle(){
		return title;
	}
	
	public double getPrice() {
		return price;
	}
	
	public java.lang.String toString() {
		return this.gettitle() + " " + this.getyearPublished() + " " + this.getPrice();
	}
	
	public int hashCode() {
		return this.hashCode();
	}
	
	public boolean equals(java.lang.Object obj)	{
		if(obj.getClass() == this.getClass())
		{
			return true;
		}
		return false;
	}
	
	public int compareTo(Book other) {
		if(this.getPrice() > other.getPrice())
		{
			return 1;
		}
		else if(this.getPrice() < other.getPrice())
		{
			return -1;
		}
		else return 0;
	}
	
	
}
