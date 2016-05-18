package de.test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;

import de.test.api.utils.XMLGregorianCalendarUtil;

@SuppressWarnings("serial")
@WebServlet("/startSmallTalk")
public class StartSmallTalkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/startSmallTalk.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        final Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
        final String name = request.getParameter("name");
        final String dateAsString = request.getParameter("date");
        
        Date date = null;
        try {
        	XMLGregorianCalendar gregorianCaldendar = XMLGregorianCalendarUtil.toGregorianCaldendar(dateAsString);
        	date = XMLGregorianCalendarUtil.toDate(gregorianCaldendar);
		} catch (ParseException e) {
			// do nothing
		}

    	String smallTalkComment = HelloWorldRequestExecutor.sendStartSmallTalkRequest(name, date);
        messages.put("smallTalkComment", smallTalkComment);

        request.getRequestDispatcher("/startSmallTalk.jsp").forward(request, response);
    }

}