package net.aimeizi.resteasy.example;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.providers.jackson.Jackson2JsonpInterceptor;
import org.jboss.resteasy.providers.ExceptionProvider;

public class BookApplication extends Application{

	private Set<Object> singletons = new HashSet<Object>();
	
	public BookApplication() {
		singletons.add(new Jackson2JsonpInterceptor());//使用Jackson时JSONP支持
		singletons.add(new ExceptionProvider());//注册请求异常Provider
		singletons.add(new BookRestService());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
