package net.aimeizi.resteasy.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlClient {
	
	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/v1/api/bookstore/books");
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
			conn.disconnect();
		} catch (Exception e) {
			
		}
	}
	
}
