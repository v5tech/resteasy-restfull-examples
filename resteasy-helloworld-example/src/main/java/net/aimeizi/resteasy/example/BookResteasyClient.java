package net.aimeizi.resteasy.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

public class BookResteasyClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getBook();
		System.out.println();
		getBooksArray();
		System.out.println();
		getBooksList();
		System.out.println();
		getBooksMap();
		System.out.println();
		getBooksSet();
		System.out.println();
		addBook();
		System.out.println();
		addBooksList();
		System.out.println();
		addBooksArray();
		System.out.println();
		addBooksSet();
		System.out.println();
		addBooksMap();
		System.out.println();
		updateBook();
		System.out.println();
		removeBook();
	}

	
	private static String getBasicAuthenticationEncoding() {
		String usernamepassword = "admin:sysadmin";
        return new String(Base64.encodeBase64(usernamepassword.getBytes()));
	}
	
	
	private static void removeBook() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		Response response = client.target("http://localhost:8080/v1/api")
				.path("bookstore/book")
				.path("1")
				.request()
				.header("Authorization", "Basic " + getBasicAuthenticationEncoding())
				.accept(MediaType.APPLICATION_JSON).delete();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("---------------------------------------");
		response = client.target("http://localhost:8080/v1/api")
				.path("bookstore/book")
				.path("1")
				.request()
				.header("Authorization", "Basic " + getBasicAuthenticationEncoding())
				.accept(MediaType.APPLICATION_XML)
				.delete();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

	private static void updateBook() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		Book book = new Book(1,"金庸","987634556","书剑恩仇录",publisher);
		Response response = client.target("http://localhost:8080/v1/api")
				.path("bookstore/book")
				.request()
				.header("Authorization", "Basic " + getBasicAuthenticationEncoding())
				.accept(MediaType.APPLICATION_JSON)
				.put(Entity.entity(book, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("---------------------------------------");
		response = client.target("http://localhost:8080/v1/api")
				.path("bookstore/book")
				.request()
				.header("Authorization", "Basic " + getBasicAuthenticationEncoding())
				.accept(MediaType.APPLICATION_XML)
				.put(Entity.entity(book, MediaType.APPLICATION_XML));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

	private static void addBook() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		Book book = new Book(1,"金庸","987634556","书剑恩仇录",publisher);
		Response response = client.target("http://localhost:8080/v1/api")
				.path("bookstore/book")
				.request()
				.header("Authorization", "Basic " + getBasicAuthenticationEncoding())
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(book, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("---------------------------------------");
		response = client.target("http://localhost:8080/v1/api")
				.path("bookstore/book")
				.request()
				.header("Authorization", "Basic " + getBasicAuthenticationEncoding())
				.accept(MediaType.APPLICATION_XML)
				.post(Entity.entity(book, MediaType.APPLICATION_XML));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	private static void addBooksList() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		List<Book> books = new ArrayList<Book>();
		Book book;
		for (int i = 1; i <= 20; i++) {
			book = new Book(i,"金庸","987634556","书剑恩仇录",publisher);
			books.add(book);
		}
		Response response = client.target("http://localhost:8080/v1/api")
				.path("bookstore/list")
				.request()
				.header("Authorization", "Basic " + getBasicAuthenticationEncoding())
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(books, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("---------------------------------------");
		response = client.target("http://localhost:8080/v1/api")
				.path("bookstore/list")
				.request()
				.header("Authorization", "Basic " + getBasicAuthenticationEncoding())
				.accept(MediaType.APPLICATION_XML)
				.post(Entity.entity(books, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	private static void addBooksArray() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		Book[] books = new Book[20];
		Book book;
		for (int i = 0; i <= 19; i++) {
			book = new Book(i,"金庸","987634556","书剑恩仇录",publisher);
			books[i] = book;
		}
		Response response = client.target("http://localhost:8080/v1/api")
				.path("bookstore/array")
				.request()
				.header("Authorization", "Basic " + getBasicAuthenticationEncoding())
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(books, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("---------------------------------------");
		response = client.target("http://localhost:8080/v1/api")
				.path("bookstore/array")
				.request()
				.header("Authorization", "Basic " + getBasicAuthenticationEncoding())
				.accept(MediaType.APPLICATION_XML)
				.post(Entity.entity(books, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	private static void addBooksSet() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		Set<Book> books = new HashSet<Book>();
		Book book;
		for (int i = 1; i <= 20; i++) {
			book = new Book(i,"金庸","987634556","书剑恩仇录",publisher);
			books.add(book);
		}
		Response response = client.target("http://localhost:8080/v1/api")
				.path("bookstore/set")
				.request()
				.header("Authorization", "Basic " + getBasicAuthenticationEncoding())
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(books, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("---------------------------------------");
		response = client.target("http://localhost:8080/v1/api")
				.path("bookstore/set")
				.request()
				.header("Authorization", "Basic " + getBasicAuthenticationEncoding())
				.accept(MediaType.APPLICATION_XML)
				.post(Entity.entity(books, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	private static void addBooksMap() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		Map<String,Book> books = new HashMap<String,Book>();
		Book book;
		for (int i = 1; i <= 20; i++) {
			book = new Book(i,"金庸","987634556","书剑恩仇录",publisher);
			books.put(String.valueOf(i),book);
		}
		Response response = client.target("http://localhost:8080/v1/api")
				.path("bookstore/map")
				.request()
				.header("Authorization", "Basic " + getBasicAuthenticationEncoding())
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(books, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("---------------------------------------");
		response = client.target("http://localhost:8080/v1/api")
				.path("bookstore/map")
				.request()
				.header("Authorization", "Basic " + getBasicAuthenticationEncoding())
				.accept(MediaType.APPLICATION_XML)
				.post(Entity.entity(books, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	

	private static void getBooksList() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		System.out.println("----------------JSON-----------------------");
		Response response = client.target("http://localhost:8080/v1/api").path("bookstore/list").request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------JSNOP-----------------------");
		response = client.target("http://localhost:8080/v1/api").path("bookstore/list").queryParam("callback", "books").request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------XML-----------------------");
		response = client.target("http://localhost:8080/v1/api").path("bookstore/list").request().accept(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	private static void getBooksArray() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		System.out.println("----------------JSON-----------------------");
		Response response = client.target("http://localhost:8080/v1/api").path("bookstore/array").request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------JSNOP-----------------------");
		response = client.target("http://localhost:8080/v1/api").path("bookstore/array").queryParam("callback", "books").request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------XML-----------------------");
		response = client.target("http://localhost:8080/v1/api").path("bookstore/array").request().accept(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

	
	private static void getBooksMap() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		System.out.println("----------------JSON-----------------------");
		Response response = client.target("http://localhost:8080/v1/api").path("bookstore/map").request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------JSNOP-----------------------");
		response = client.target("http://localhost:8080/v1/api").path("bookstore/map").queryParam("callback", "books").request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------XML-----------------------");
		response = client.target("http://localhost:8080/v1/api").path("bookstore/map").request().accept(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	private static void getBooksSet() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		System.out.println("----------------JSON-----------------------");
		Response response = client.target("http://localhost:8080/v1/api").path("bookstore/set").request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------JSNOP-----------------------");
		response = client.target("http://localhost:8080/v1/api").path("bookstore/set").queryParam("callback", "books").request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------XML-----------------------");
		response = client.target("http://localhost:8080/v1/api").path("bookstore/set").request().accept(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}
	
	
	
	private static void getBook() {
		
		ResteasyClient client = new ResteasyClientBuilder().build();
		System.out.println("----------------JSON-----------------------");
		Response response = client.target("http://localhost:8080/v1/api").path("bookstore/book").path("1").request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------JSNOP-----------------------");
		response = client.target("http://localhost:8080/v1/api").path("bookstore/book").path("1").queryParam("callback", "books").request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------XML-----------------------");
		response = client.target("http://localhost:8080/v1/api").path("bookstore/book").path("1").request().accept(MediaType.APPLICATION_XML).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

}
