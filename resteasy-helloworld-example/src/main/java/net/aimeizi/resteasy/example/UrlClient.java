package net.aimeizi.resteasy.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.codec.binary.Base64;

public class UrlClient {
	
	public static void main(String[] args) {
		GetBooks();
		System.out.println();
		GetBook();
		System.out.println();
		AddBook();
		System.out.println();
		UpdateBook();
		System.out.println();
		DeleteBook();
	}

	private static String getBasicAuthenticationEncoding() {
		String usernamepassword = "admin:sysadmin";
        return new String(Base64.encodeBase64(usernamepassword.getBytes()));
	}
	
	private static void DeleteBook() {
		try {
			URL url = new URL("http://localhost:8080/v1/api/bookstore/book/1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//设置Basic认证的用户名密码
			conn.setRequestProperty("Authorization", "Basic " + getBasicAuthenticationEncoding());
			conn.setRequestMethod("DELETE");
			conn.setDoInput(true);
			conn.setRequestProperty("Accept", "application/xml");
			
			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output = br.readLine();
			System.out.println(output);
			
			System.out.println("----------------------------------------------------------------");
			
			conn = (HttpURLConnection) url.openConnection();
			//设置Basic认证的用户名密码
			conn.setRequestProperty("Authorization", "Basic " + getBasicAuthenticationEncoding());
			conn.setRequestMethod("DELETE");
			conn.setDoInput(true);
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			output = br.readLine();
			System.out.println(output);
			
			conn.disconnect();
		} catch (Exception e) {
			
		}
	}

	

	private static void UpdateBook() {
		try {
			URL url = new URL("http://localhost:8080/v1/api/bookstore/book");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("PUT");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			//设置Basic认证的用户名密码
			conn.setRequestProperty("Authorization", "Basic " + getBasicAuthenticationEncoding());
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.setRequestProperty("Accept", "application/xml");
			OutputStream outputStream = conn.getOutputStream();
			
			Publisher publisher = new Publisher(1,"陕西师范大学出版社");
			Book book = new Book(1,"金庸","78438321468","书剑恩仇录",publisher);
			
			StringWriter writer = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(book, writer);
			
			outputStream.write(writer.getBuffer().toString().getBytes("utf-8"));
			outputStream.close();
			
			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output = br.readLine();
			System.out.println(output);
			
			System.out.println("----------------------------------------------------------------");
			
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("PUT");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			//设置Basic认证的用户名密码
			conn.setRequestProperty("Authorization", "Basic " + getBasicAuthenticationEncoding());
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.setRequestProperty("Accept", "application/json");
			outputStream = conn.getOutputStream();
			outputStream.write(writer.getBuffer().toString().getBytes("utf-8"));
			outputStream.close();
			
			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			output = br.readLine();
			System.out.println(output);
			
			conn.disconnect();
		} catch (Exception e) {
			
		}
	}

	private static void AddBook() {
		try {
			URL url = new URL("http://localhost:8080/v1/api/bookstore/book");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			//设置Basic认证的用户名密码
			conn.setRequestProperty("Authorization", "Basic " + getBasicAuthenticationEncoding());
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.setRequestProperty("Accept", "application/xml");
			OutputStream outputStream = conn.getOutputStream();
			
			Publisher publisher = new Publisher(1,"陕西师范大学出版社");
			Book book = new Book(1,"金庸","78438321468","书剑恩仇录",publisher);
			
			StringWriter writer = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(book, writer);
			
			outputStream.write(writer.getBuffer().toString().getBytes("utf-8"));
			outputStream.close();
			
			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output = br.readLine();
			System.out.println(output);
			
			System.out.println("----------------------------------------------------------------");
			
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			//设置Basic认证的用户名密码
			conn.setRequestProperty("Authorization", "Basic " + getBasicAuthenticationEncoding());
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.setRequestProperty("Accept", "application/json");
			outputStream = conn.getOutputStream();
			outputStream.write(writer.getBuffer().toString().getBytes("utf-8"));
			outputStream.close();
			
			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			output = br.readLine();
			System.out.println(output);
			
			conn.disconnect();
		} catch (Exception e) {
			
		}
	}

	private static void GetBook() {
		try {
			URL url = new URL("http://localhost:8080/v1/api/bookstore/book/1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");

			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output = br.readLine();
			System.out.println(output);
			
			System.out.println("----------------------------------------------------------------");
			
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			output = br.readLine();
			System.out.println(output);
			
			System.out.println("----------------------------------------------------------------");
			
			url = new URL("http://localhost:8080/v1/api/bookstore/book/1?callback=book");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			output = br.readLine();
			System.out.println(output);
			
			conn.disconnect();
		} catch (Exception e) {
			
		}
	}
	
	private static void GetBooks() {
		try {
			URL url = new URL("http://localhost:8080/v1/api/bookstore/list");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");

			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output = br.readLine();
			System.out.println(output);
			
			System.out.println("----------------------------------------------------------------");
			
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			output = br.readLine();
			System.out.println(output);
			
			System.out.println("----------------------------------------------------------------");
			
			url = new URL("http://localhost:8080/v1/api/bookstore/list?callback=books");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			output = br.readLine();
			System.out.println(output);
			
			conn.disconnect();
		} catch (Exception e) {
			
		}
	}
	
}
