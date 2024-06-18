package com.example.bookRestApi;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class Book {
	private @Id @GeneratedValue Long id;
	private String isbn;
	private String title;
	private int numPages;
	private String author;
	private String imgUrl;
	private boolean borrowed;
	
	Book(){};
	
	Book(String isbn, String title, int numPages, String author, String imgUrl, boolean borrowed){
		this.isbn = isbn;
		this.title = title;
		this.numPages = numPages;
		this.author = author;
		this.imgUrl = imgUrl;
		this.borrowed = borrowed;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumPages() {
		return this.numPages;
	}

	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public boolean getBorrowed() {
		return this.borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	};
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		};
		if(!(o instanceof Book)) {
			return false;
		};
		Book book = (Book) o;
		return Objects.equals(this.id, book.id) && Objects.equals(this.isbn, book.isbn) && Objects.equals(this.title, book.title) && Objects.equals(this.numPages, book.numPages) && Objects.equals(this.author, book.author) && Objects.equals(this.imgUrl, book.imgUrl) && Objects.equals(this.borrowed, book.borrowed);
	};
	
	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.isbn, this.title, this.numPages, this.author, this.imgUrl, this.borrowed);
	};
	
	@Override
	public String toString() {
		return "Book{" + "id=" + this.id + ", isbn='" + this.isbn + '\'' + ", title=" + this.title + '\'' + "numPages=" + this.numPages + '\'' + ", author=" + this.author + '\'' + ", imgUrl=" + this.imgUrl + '\'' + ", borrowed=" + this.borrowed + '\'' + "}";
	};
}
