package net.aimeizi.resteasy.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
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
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class BookRestService {
	
	
	@GET
	@Path("/set")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@PermitAll
	public Set<Book> getBooksSet() {
		Set<Book> books = new HashSet<Book>();
		Book book;
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		for (int i = 1; i <= 20; i++) {
			book = new Book(i,"金庸","987634556","书剑恩仇录",publisher);
			books.add(book);
		}
		return books;
	}
	
	@GET
	@Path("/map")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@PermitAll
	public Map<String,Book> getBooksMap() {
		Map<String,Book> books = new HashMap<String,Book>();
		Book book;
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		for (int i = 1; i <= 20; i++) {
			book = new Book(i,"金庸","987634556","书剑恩仇录",publisher);
			books.put(String.valueOf(i), book);
		}
		return books;
	}
	
	
	@GET
	@Path("/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@PermitAll
	public List<Book> getBooksList() {
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
	@Path("/array")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@PermitAll
	public Book[] getBooksArray() {
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		Book[] books = new Book[20];
		Book book;
		for (int i = 0; i <= 19; i++) {
			book = new Book(i,"金庸","987634556","书剑恩仇录",publisher);
			books[i] = book;
		}
		return books;
	}
	

	@GET
	@Path("/book/{isbn:[\\da-zA-Z]+}")//使用正则对isbn进行严格限定。即isbn只能为数字和字母
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,"text/json"})
	@PermitAll
	public Book getBook(@PathParam("isbn") String isbn) {
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		Book book = new Book(1,"金庸",isbn,"书剑恩仇录",publisher);
		return book;
	}
	
	@POST
	@Path("/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@RolesAllowed("manager")//具有manager角色的用户才可以调用该方法
	public List<Book> addBooksList(List<Book> books) {
		return books;
	}
	
	@POST
	@Path("/array")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@RolesAllowed("manager")//具有manager角色的用户才可以调用该方法
	public List<Book> addBooksArray(Book[] books) {
		return Arrays.asList(books);
	}
	
	
	@POST
	@Path("/set")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@RolesAllowed("manager")//具有manager角色的用户才可以调用该方法
	public Set<Book> addBooksSet(Set<Book> books) {
		return books;
	}
	
	
	@POST
	@Path("/map")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@RolesAllowed("manager")//具有manager角色的用户才可以调用该方法
	public Map<String,Book> addBooksMap(Map<String,Book> books) {
		return books;
	}
	
	
	@POST
	@Path("/book")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@RolesAllowed("manager")//具有manager角色的用户才可以调用该方法
	public Book addBook(Book book) {
		return book;
	}
	
	
	@PUT
	@Path("/book")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@RolesAllowed("manager")//具有manager角色的用户才可以调用该方法
	public Book updateBook(Book book) {
		return book;
	}
	

	@DELETE
	@Path("/book/{id:\\d+}")//使用正则严格限定.id只能为数字
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@RolesAllowed("manager")//具有manager角色的用户才可以调用该方法
	public Book removeBook(@PathParam("id") String id) {
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		Book book = new Book(Integer.parseInt(id),"金庸","987634556","书剑恩仇录",publisher);
		return book;
	}
}
