package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/Header")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		Enumeration<String> headerNames = request.getHeaderNames();
		
		while (headerNames.hasMoreElements() ) {
			String name = headerNames.nextElement();
			String value = request.getHeader(name);
			
			out.println("Name: " + name + "   ----::::---   Value: " + value + "</br>");
		}
		
	}

    
}
