package com.example.SpringBootJdbcMysql.model;

public class Book {
	
	private int book_id;
	private String book_name;
	private String author_name;
	private String book_type;
	private int total_pages;
	private int quantity;
	
	public Book() {
		
	}
	
	public Book(int book_id, String book_name, String author_name, String book_type, int total_pages, int quantity) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.author_name = author_name;
		this.book_type = book_type;
		this.total_pages = total_pages;
		this.quantity = quantity;
	}
	
	public Book(String book_name, String author_name, String book_type, int total_pages, int quantity) {
		super();
		this.book_name = book_name;
		this.author_name = author_name;
		this.book_type = book_type;
		this.total_pages = total_pages;
		this.quantity = quantity;
	}

	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getBook_type() {
		return book_type;
	}
	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", author_name=" + author_name + ", book_type="
				+ book_type + ", total_pages=" + total_pages + ", quantity=" + quantity + "]";
	}

}
