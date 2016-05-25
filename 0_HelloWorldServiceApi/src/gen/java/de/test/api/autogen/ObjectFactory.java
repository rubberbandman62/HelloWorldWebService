//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.05.25 um 04:40:27 PM CEST 
//


package de.test.api.autogen;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.test.api.autogen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.test.api.autogen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHelloRequest }
     * 
     */
    public SayHelloRequest createSayHelloRequest() {
        return new SayHelloRequest();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link SmallTalkCommentRequest }
     * 
     */
    public SmallTalkCommentRequest createSmallTalkCommentRequest() {
        return new SmallTalkCommentRequest();
    }

    /**
     * Create an instance of {@link SmallTalkCommentResponse }
     * 
     */
    public SmallTalkCommentResponse createSmallTalkCommentResponse() {
        return new SmallTalkCommentResponse();
    }

    /**
     * Create an instance of {@link HelloWorldServiceError }
     * 
     */
    public HelloWorldServiceError createHelloWorldServiceError() {
        return new HelloWorldServiceError();
    }

}
