package net.aimeizi.resteasy.example;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class BookApplication extends Application{

	private Set<Object> singletons = new HashSet<Object>();
	
	public BookApplication() {
		singletons.add(new BookRestService());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
