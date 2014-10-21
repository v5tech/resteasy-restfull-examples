package net.aimeizi.resteasy.example;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import net.aimeizi.resteasy.Pretty;

import org.jboss.resteasy.annotations.providers.jackson.Formatted;

@XmlRootElement(name = "publisher")
@XmlType(propOrder={"id","pubname"})//定义xml中元素的顺序
@Pretty
@Formatted
//@NoJackson//不使用Jackson而使用Jettison and JAXB输出JSON
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

	@XmlTransient//忽略掉此元素
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
}
