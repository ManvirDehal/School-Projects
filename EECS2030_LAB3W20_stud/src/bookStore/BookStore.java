package bookStore;

/**
 * A class representing a <strong> book store </strong> that has an <strong>
 * owner</strong> . A book store <strong> <em> owns a collection (or possibly
 * collections) of books, but does not own the books themselves</em>
 * </strong>.
 * 
 * <p>
 * Only the owner of the book store is able to sell books from the book store.
 * <strong> <em> The book store does NOT own its owner</em> </strong>. 
 * </p>
 */

import java.util.*;
public class BookStore extends java.lang.Object{
	
		private TreeMap<Book, Integer> books = new TreeMap<Book, Integer>();
		private BookStoreOwner owner = new BookStoreOwner(null);

		/**
		 * Initializes this book store so that it has the specified owner and no
		 * books.
		 * 
		 * @param owner the owner of this book store
		 */
		public BookStore(BookStoreOwner owner) {
			// COMPLETE THIS
			books.clear();
			this.owner = owner;
			}

		/**
		 * Initializes this book store by copying another book store. This book store will
		 * have the same owner and the same number and type of books as the other
		 * book store.
		 * 
		 * @param other the book store to copy
		 */
		public BookStore(BookStore other) {
			// COMPLETE THIS
			this.books = other.books;
			this.owner = other.owner;
		}

		/**
		 * Returns the owner of this book store.
		 * 
		 * <p>
		 * This method is present only for testing purposes. Returning the owner of this
		 * book store allows any user to sell books from the book store (because any
		 * user can become the owner of this book store)!
		 * 
		 * @return the owner of this book store
		 */
		public BookStoreOwner getOwner() {
			// ALREADY IMPLEMENTED; DO NOT MODIFY
			return this.owner;
		}

		/**
		 * Allows the current owner of this book store to give this book store to a new
		 * owner.
		 * 
		 * @param currentOwner the current owner of this book store
		 * @param newOwner     the new owner of this book store
		 * @throws IllegalArgumentException if currentOwner reference is not the reference of the
		 * current owner of this book store
		 */
		public void changeOwner(BookStoreOwner currentOwner, BookStoreOwner newOwner) {
			// COMPLETE THIS
			if(currentOwner == this.getOwner())
			{
				newOwner = currentOwner;
			}
			else throw new IllegalArgumentException("");
		}
		/**
		 * Adds the specified books to this book store.
		 * 
		 * @param books a list of books to add to this book store
		 */
		
		
		public void add(List<Book> books) {
			// COMPLETE THIS
			int count = 0;
			for(int x = 0; x < books.size(); x++)
			{
				this.books.put(books.get(x), count);
				count++;
			}
			
			//System.out.println(this.books + " " + keys.size());
			
		}

		/**
		 * Returns true if this book store contains the specified book, and false
		 * otherwise.
		 * 
		 * @param book a book
		 * @return true if this book store contains the specified book, and false
		 *         otherwise
		 */
		public boolean contains(Book book) {
			// COMPLETE THIS
			if(books.containsKey(book))
			{
				return true;
			}
			else return false;
			
		}

		/**
		 * Allows the owner of this book store to sell a single book equal to the
		 * specified book from this book store.
		 * 
		 * <p>
		 * If the specified user is not equal to the owner of this book store, then the
		 * book is not sold from this book store, and null is returned.
		 * 
		 * @param user    the person trying to sell the book
		 * @param book     a book
		 * @return a book equal to the specified book from this book store, or null
		 *         if user is not the owner of this book store @pre. the book store
		 *         contains a book equal to the specified book
		 */
		public Book sellingsingleBook(BookStoreOwner user, Book book) {
			// COMPLETE THIS
			if(owner == user && books.containsKey(book)) {
				//You still have to remove the book from the TreeMap
				return book;
			}
			return null;
		}

		/**
		 * Allows the owner of this book store to sell the smallest number of books
		 * whose total price value in dollars is equal or less than to the specified
		 * price value in dollars. Try from the most expensive book and you may want 
		 * to use descendingKeySet() method.
		 * 
		 * <p>
		 * Returns the empty list if the specified user is not equal to the owner of
		 * this book store.
		 * </p>
		 * 
		 * @param user       the person trying to sell books from this book store
		 * @param pricevalue a value in dollars
		 * @return the smallest number of books whose total price value in dollars is
		 *         equal to the specified value in dollars from this book store @pre. the
		 *         book store contains a group of books whose total price value is
		 *         equal to specified value
		 */
		public List<Book> sellingBooks(BookStoreOwner user, int pricevalue) {
			// COMPLETE THIS
			Set<Book> keys = books.descendingKeySet();
			List<Book> list = new ArrayList<Book>();
			List<Book> toSell = new ArrayList<Book>();
			list.addAll(keys);
			if(owner == user) {
				int price = 0;
				for(int x = 0; x < list.size(); x++)
				{
					if(price + list.get(x).getPrice() <= pricevalue)
					{
						price += list.get(x).getPrice();
						toSell.add(list.get(x));
					}
					if(x == list.size()-1 && price != pricevalue)
					{
						x = -1;
					}
				}
			}
			return toSell;
		}
	}



