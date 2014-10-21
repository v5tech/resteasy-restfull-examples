package org.jboss.resteasy.providers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * ExceptionProvider友好的错误消息
 * @author welcome
 *
 */
@Provider
public class ExceptionProvider implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		return Response.ok("{\"status\":\"500\",\"msg\":\""+exception.getMessage()+"\"}",MediaType.APPLICATION_JSON).build();
	}

}
