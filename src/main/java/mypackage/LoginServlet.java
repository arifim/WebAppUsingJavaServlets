package mypackage;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dis=null;
		java.io.PrintWriter out=response.getWriter();
		String user=request.getParameter("tlogin");
		String pass=request.getParameter("tpassword");
		if(user.equals("admin")&&pass.equals("admin"))
		{
			dis=getServletContext().getRequestDispatcher("/Welcome.html");
			dis.forward(request, response);
		}
		else
		{
			dis=getServletContext().getRequestDispatcher("/Login.jsp");
			request.setAttribute("errorText", "incorrect id or password");
			dis.include(request, response);
			
			out.println("<p style=color:red> incorrect id or password</p>");
		}
	}

}