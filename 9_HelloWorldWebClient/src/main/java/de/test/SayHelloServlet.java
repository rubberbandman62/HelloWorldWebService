package de.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/sayhello")
public class SayHelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/sayHello.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        final Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
        final String name = request.getParameter("name");

    	String helloText = HelloWorldRequestExecutor.sendSayHelloWordRequest(name);
        messages.put("helloText", helloText);

        request.getRequestDispatcher("/sayHello.jsp").forward(request, response);
    }

}