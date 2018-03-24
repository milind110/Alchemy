package com.glarimy.cmad;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Book {
	@Id
	private String isbn;
	private String author;

	public Book() {

	}

	public Book(String isbn, String author) {
		super();
		this.isbn = isbn;
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", author=" + author + "]";
	}

}
