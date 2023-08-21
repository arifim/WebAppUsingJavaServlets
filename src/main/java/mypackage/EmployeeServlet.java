package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection con;
	private PreparedStatement statement;
	
	@Override
	public void init() {
		con = MyConnector.getConnection();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String teid=request.getParameter("tempid");
		String ename=request.getParameter("tempname");
		double sal=Double.parseDouble(request.getParameter("tempsalary"));
		
		try {
			statement = con.prepareStatement("INSERT INTO Employee(employeeid, employeename, employeesalary) VALUES(?, ?, ?)");
			statement.setInt(1, Integer.parseInt(teid));
			statement.setString(2, ename);
			statement.setDouble(3, sal);
			int res = statement.executeUpdate();
			if (res > 0) {
				out.println("OK");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		out.println("Id is "+teid);
		out.println("Employee name is "+ename);
		out.println("Salary is "+sal);
		System.out.println("Hello");
		
	}

}
