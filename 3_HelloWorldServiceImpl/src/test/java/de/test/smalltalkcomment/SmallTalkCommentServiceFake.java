package de.test.smalltalkcomment;

import smalltalkcomment.webservice.demo.moglicc.net.GiveSmallTalkCommentExceptionMessage;
import smalltalkcomment.webservice.demo.moglicc.net.GiveSmallTalkCommentRequestWrapper;
import smalltalkcomment.webservice.demo.moglicc.net.GiveSmallTalkCommentResponse;
import smalltalkcomment.webservice.demo.moglicc.net.GiveSmallTalkCommentResponseWrapper;
import smalltalkcomment.webservice.demo.moglicc.net.SmallTalkComment;

/**
 * This is a fake object that replaces the real implementation of
 * the SmallTalkCommentSoapService and simply returns the 
 * fakeComment previously set or the default comment.
 * 
 * @author Reik Oberrath
 */
public class SmallTalkCommentServiceFake implements SmallTalkComment {

	private String fakeComment = "DefaultTestComment"; 
	
	public SmallTalkCommentServiceFake() {
		fakeComment = "DefaultTestComment";
	}
	
	@Override
	public GiveSmallTalkCommentResponseWrapper giveSmallTalkComment(GiveSmallTalkCommentRequestWrapper requestMapperIgnored)
		   throws GiveSmallTalkCommentExceptionMessage 
	{
		GiveSmallTalkCommentResponseWrapper toReturn = new GiveSmallTalkCommentResponseWrapper();
		GiveSmallTalkCommentResponse response = new GiveSmallTalkCommentResponse();
		response.setSmallTalkComment(fakeComment);
		toReturn.setResponse(response);
		
		return toReturn;
	}

	public String getComment() {
		return fakeComment;
	}

	public void setComment(String comment) {
		this.fakeComment = comment;
	}

	
}
