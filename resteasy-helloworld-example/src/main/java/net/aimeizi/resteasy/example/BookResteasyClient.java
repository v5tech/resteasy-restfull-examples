package net.aimeizi.resteasy.example;

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
		getBooks();
		System.out.println();
		getBook();
		System.out.println();
		addBook();
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

	private static void getBooks() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		System.out.println("----------------JSON-----------------------");
		Response response = client.target("http://localhost:8080/v1/api").path("bookstore/books").request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------JSNOP-----------------------");
		response = client.target("http://localhost:8080/v1/api").path("bookstore/books").queryParam("callback", "books").request().accept(MediaType.APPLICATION_JSON).get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
		System.out.println("----------------XML-----------------------");
		response = client.target("http://localhost:8080/v1/api").path("bookstore/books").request().accept(MediaType.APPLICATION_XML).get();
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
