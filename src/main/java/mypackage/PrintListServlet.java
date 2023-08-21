package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PrintListServlet")
public class PrintListServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	List<String> obj;
	
	@Override
	public void init() {
		obj = new ArrayList<>();
		
		obj.add("Apple");
		obj.add("MSI");
		obj.add("HP");
		obj.add("Dell");
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<table border=1>");
		for(String x: obj) {
			out.println("<tr><td>" + x + "</td></tr>");
		}
		
		
	}

    

}
