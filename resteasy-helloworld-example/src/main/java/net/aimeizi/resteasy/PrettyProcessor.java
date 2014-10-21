package net.aimeizi.resteasy;

import java.lang.annotation.Annotation;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import org.jboss.resteasy.annotations.DecorateTypes;
import org.jboss.resteasy.spi.interception.DecoratorProcessor;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
@DecorateTypes({ "text/*+xml", "application/*+xml" })
public class PrettyProcessor implements DecoratorProcessor<Marshaller, Pretty> {
	
	@SuppressWarnings("rawtypes")
	public Marshaller decorate(Marshaller target, Pretty annotation,Class type, Annotation[] annotations, MediaType mediaType) {
		try {
			target.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		} catch (PropertyException e) {
			e.printStackTrace();
		}
		return target;
	}
	
}
