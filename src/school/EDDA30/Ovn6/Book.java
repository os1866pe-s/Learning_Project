package school.EDDA30.Ovn6;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Book {
	private String isbn;
	private String titel;
	private String author;

	public Book(String isbn, String title, String author) {
		this.isbn = isbn;
		this.titel = title;
		this.author = author;
	}

	@Override
	public String toString() {
		return String.format("%s: %s", author, titel);
	}

	/*
	public boolean contains(Object o) {
		if (o instanceof Book) {
			return this.isbn.equals(((Book) o).isbn);
		}
		return false;
	}
*/
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			return this.isbn.equals(((Book) obj).isbn);
		}
		return false;
	}



}
