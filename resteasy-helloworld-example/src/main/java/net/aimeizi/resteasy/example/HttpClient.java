package net.aimeizi.resteasy.example;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		createHttpGetClient();
		createHttpPostClient();
	}

	private static void createHttpPostClient() throws Exception{
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		
		Publisher publisher = new Publisher(1,"陕西师范大学出版社");
		Book book = new Book(1,"金庸","78438321468","书剑恩仇录",publisher);
		
		StringWriter writer = new StringWriter();
		JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.marshal(book, writer);
		
		try
		{
			//Define a postRequest request
			HttpPost postRequest = new HttpPost("http://localhost:8080/v1/api/bookstore/book");
			
			//Set the API media type in http content-type header
			postRequest.addHeader("content-type", "application/xml");
			
			//Set the request post body
			StringEntity userEntity = new StringEntity(writer.getBuffer().toString());
			postRequest.setEntity(userEntity);
			 
			//Send the request; It will immediately return the response in HttpResponse object if any
			HttpResponse response = httpClient.execute(postRequest);
			
			//verify the valid error code first
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 201) 
			{
				throw new RuntimeException("Failed with HTTP error code : " + statusCode);
			}
		}
		finally
		{
			//Important: Close the connect
			httpClient.close();
		}
	}

	private static void createHttpGetClient() throws Exception {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
			// Define a HttpGet request;
			// You can choose between HttpPost, HttpDelete or HttpPut also.
			// Choice depends on type of method you will be invoking.
			HttpGet getRequest = new HttpGet("http://localhost:8080/v1/api/bookstore/books");

			// Set the API media type in http accept header
			getRequest.addHeader("accept", "application/xml");

			// Send the request; It will immediately return the response in
			// HttpResponse object
			HttpResponse response = httpClient.execute(getRequest);

			// verify the valid error code first
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new RuntimeException("Failed with HTTP error code : "+ statusCode);
			}
			// Now pull back the response object
			HttpEntity httpEntity = response.getEntity();
			String output = EntityUtils.toString(httpEntity);
			// Lets see what we got from API
			System.out.println(output);
		} finally {
			// Important: Close the connect
			httpClient.close();
		}
	}

}
