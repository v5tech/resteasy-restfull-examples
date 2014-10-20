package net.aimeizi.resteasy.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class Book {
	private int id;
	private String author;
	private String isbn;
	private String title;
	
	private Publisher publisher;
	
	public Book() {
	}

	public Book(int id,String author, String isbn, String title, Publisher publisher) {
		this.id = id;
		this.author = author;
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
	}
	
	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@XmlElement
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	
}