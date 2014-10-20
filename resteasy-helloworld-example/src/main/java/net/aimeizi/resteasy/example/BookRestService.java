package net.aimeizi.resteasy.example;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bookstore")
public class BookRestService {

	@GET
	@Path("/books")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,"application/javascript"})
	public List<Book> getBooks() {
		List<Book> books = new ArrayList<Book>();
		Book book;
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		for (int i = 1; i <= 20; i++) {
			book = new Book(i,"金庸","987634556","书剑恩仇录",publisher);
			books.add(book);
		}
		return books;
	}

	@GET
	@Path("/book/{isbn}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Book getBook(@PathParam("isbn") String isbn) {
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		Book book = new Book(1,"金庸",isbn,"书剑恩仇录",publisher);
		return book;
	}

	@POST
	@Path("/book")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Book addBook(Book book) {
		return book;
	}
	
	
	@PUT
	@Path("/book")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Book updateBook(Book book) {
		return book;
	}
	

	@DELETE
	@Path("/book/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Book removeBook(@PathParam("id") String id) {
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		Book book = new Book(Integer.parseInt(id),"金庸","987634556","书剑恩仇录",publisher);
		return book;
	}
}
