package de.test.smalltalkcomment;

import de.test.SmallTalkCommentProvider;
import smalltalkcomment.webservice.demo.moglicc.net.SmallTalkComment;

/**
 * Test wrapper to access package friendly fields. 
 * 
 * @author Reik Oberrath
 */
public class SmallTalkCommentHelperUnitTestWrapper extends SmallTalkCommentHelper 
{
    
    public void setServicePort(SmallTalkComment servicePort) {
		this.servicePort = servicePort;
	}

	public void setSmallTalkCommentProvider(SmallTalkCommentProvider smallTalkCommentProvider) {
		this.smallTalkCommentProvider = smallTalkCommentProvider;
	}
	
}
