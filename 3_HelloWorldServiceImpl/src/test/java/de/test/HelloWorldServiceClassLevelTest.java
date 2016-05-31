package de.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import de.test.api.autogen.SayHelloRequest;
import de.test.api.autogen.SayHelloResponse;
import de.test.api.autogen.SmallTalkCommentRequest;
import de.test.api.autogen.SmallTalkCommentResponse;
import de.test.smalltalkcomment.SmallTalkCommentHelperUnitTestWrapper;
import de.test.smalltalkcomment.SmallTalkCommentServiceFake;

/**
 * High level tests of the service methods.
 * 
 * @author Reik Oberrath
 */
public class HelloWorldServiceClassLevelTest 
{
	private HelloWorldServiceImpl classUnterTest;
	private SmallTalkCommentHelperUnitTestWrapper smallTalkCommentHelperTestWrapper;
	
	// This fakes replaces the external webservice SmallTalkCommentSoapService
	private SmallTalkCommentServiceFake smallTalkCommentServiceFake;
	
    @BeforeClass
    public static void preinit() {
		new Mockito();  // needed by the framework
	}
	
	@Before
	public void setup() {
		classUnterTest = new HelloWorldServiceImpl();
		smallTalkCommentHelperTestWrapper = createSmallTalkCommentHelperTestWrapper();
		
		/* This injection of the TestWrapper is possible, because the variable
		 * smallTalkCommentHelper in HelloWorldService is package friendly!!! */
		classUnterTest.smallTalkCommentHelper = smallTalkCommentHelperTestWrapper;
	}

	/**
	 * Creates the fake for the external webservice SmallTalkCommentService
	 */
	private SmallTalkCommentHelperUnitTestWrapper createSmallTalkCommentHelperTestWrapper() 
	{
		SmallTalkCommentHelperUnitTestWrapper toReturn = new SmallTalkCommentHelperUnitTestWrapper();
		smallTalkCommentServiceFake = new SmallTalkCommentServiceFake();
		
		/* This injection of the fake object into the TestWrapper is only possible, because the 
		 * variable servicePort in SmallTalkCommentHelper is package friendly!!! */
		toReturn.setServicePort(smallTalkCommentServiceFake);
		return toReturn;
	}
	
	/**
	 * Creates a mock for the HelloWorld component SmallTalkCommentProvider
	 */
	private SmallTalkCommentProvider createSmallTalkCommentProviderMock(
			final String nameToReactOn,
			final String commentToReturn) 
	{
		SmallTalkCommentProvider commentProviderMock = Mockito.mock(SmallTalkCommentProvider.class);
		when(commentProviderMock.getComment(nameToReactOn)).thenReturn(commentToReturn);
		return commentProviderMock;
	}
	
	
	// #####################################################################################
	//                  integration test on component level
	//                 with HelloWorldSmallTalkCommentProvider
	//                    WITHOUT webservice SmallTalkCommentService
	//
	//   ATTENTION: This is not a good idea !!!
	//              The following test(s) represent actually component-level tests - no 
	//              class-level tests, because the HelloWorld component 
	//              HelloWorldSmallTalkCommentProvider is not replaced with a test object.
	// ######################################################################################
	

	@Test
	public void returnsGreetingText_onlyCommentServiceIsReplaced() 
	{
		// arrange
		final String testName = "Heinz";
		final SmallTalkCommentRequest request = new SmallTalkCommentRequest();
		request.setName(testName);
		
		// act
		SmallTalkCommentResponse result = classUnterTest.startSmallTalk(request);
		
		// assert
		assertEquals("result", 
				     "Hi Heinz, how are you?" + System.getProperty("line.separator")
				     + "DefaultTestComment" + System.getProperty("line.separator")
				     + "Heinz, do you know a prominent person of your name?", 
				     result.getSmallTalkComment());
	}
	
	
	// #############################################################################
	//                END-TO-END-Tests on class level 
	//                WITHOUT HelloWorldSmallTalkCommentProvider and
	//                WITHOUT SmallTalkCommentService
	// #############################################################################

	@Test
	public void returnsHelloTextForName() 
	{
		// arrange
		final String testName = "Heinz";
		final SayHelloRequest request = new SayHelloRequest();
		request.setName(testName);
		
		// act
		SayHelloResponse result = classUnterTest.sayHello(request);
		
		// assert
		assertEquals("result", "Hello " + testName + "!", result.getHelloText());
	}
	
	@Test
	public void throwsExceptionForMissingName() 
	{
		// arrange
		final SayHelloRequest request = new SayHelloRequest();
		
		try {			
			// act
			classUnterTest.sayHello(request);
			fail("Expected exception was not thrown!");			
		} catch (Exception e) {
			// assert
			assertEquals("Error message", "java.lang.IllegalArgumentException: Name is missing.", e.getMessage());
		}
	}
	
	@Test
	public void returnsGreetingText_CommentServiceAndCommentProviderAreReplaced() 
	{
		// arrange
		final String testName = "Heinz";
		final String testComment1 = "TestComment1";
		final String testComment2 = "TestComment2";
		smallTalkCommentServiceFake.setComment(testComment1);
		SmallTalkCommentProvider commentProviderMock = createSmallTalkCommentProviderMock(testName, testComment2);
		smallTalkCommentHelperTestWrapper.setSmallTalkCommentProvider(commentProviderMock);
		
		final SmallTalkCommentRequest request = new SmallTalkCommentRequest();
		request.setName(testName);
		
		// act
		SmallTalkCommentResponse result = classUnterTest.startSmallTalk(request);
		
		// assert
		assertEquals("result", "Hi Heinz, how are you?" + System.getProperty("line.separator")
				              + testComment1 + System.getProperty("line.separator")
				              + testComment2, result.getSmallTalkComment());
	}
	
}

