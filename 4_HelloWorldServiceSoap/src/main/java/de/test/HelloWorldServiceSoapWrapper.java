package de.test;

import javax.jws.WebService;

import de.test.api.HelloWorld;
import de.test.api.HelloWorldServiceException;
import de.test.api.autogen.SayHelloRequest;
import de.test.api.autogen.SayHelloResponse;
import de.test.api.autogen.SmallTalkCommentRequest;
import de.test.api.autogen.SmallTalkCommentResponse;

/**
 * This class represents the SSD soap binding 
 * between the service impl and service api.
 */
@WebService(targetNamespace = "http://test.de/", 
            portName = "HelloWorldServicePort", 
            serviceName = "HelloWorldService")
public class HelloWorldServiceSoapWrapper implements HelloWorld {

	HelloWorldService helloWorldService = new HelloWorldService();
	
	@Override
	public SayHelloResponse sayHello(final SayHelloRequest request) 
		   throws HelloWorldServiceException
	{
		return helloWorldService.sayHello(request);
	}

	@Override
	public SmallTalkCommentResponse startSmallTalk(final SmallTalkCommentRequest request)
		   throws HelloWorldServiceException
	{
		return helloWorldService.startSmallTalk(request);
	}

}
