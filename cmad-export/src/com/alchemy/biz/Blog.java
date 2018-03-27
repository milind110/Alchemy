package com.alchemy.biz;

public class Blog {

	Blog() {

	}

	private int isbn;
	private String title;

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString() {
		return "{\"isbn\":" + isbn + ", \"title\":\"" + title + "\"}";
	}
}
