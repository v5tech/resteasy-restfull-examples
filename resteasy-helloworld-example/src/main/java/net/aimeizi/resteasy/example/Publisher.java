package net.aimeizi.resteasy.example;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "publisher")
public class Publisher {

	private int id;
	private String pubname;
	private List<Book> books;
	
	public Publisher() {
		
	}

	public Publisher(int id, String pubname) {
		super();
		this.id = id;
		this.pubname = pubname;
	}

	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getPubname() {
		return pubname;
	}

	public void setPubname(String pubname) {
		this.pubname = pubname;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
}
