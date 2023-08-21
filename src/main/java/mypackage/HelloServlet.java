package mypackage;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/calculator")
public class HelloServlet extends HttpServlet {
	
	
	private Connection con = null;
	private PreparedStatement statement;
	
	private static final long serialVersionUID = -1902469838369596662L;
	
	
	@Override
	public void init() {
		con = MyConnector.getConnection();
	}
	

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		
		List<Product> plist = new ArrayList<>();
		try {
			statement = con.prepareStatement("select * from product");
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				Product p = new Product();
				p.setProductID(result.getInt(1));
				p.setProductName(result.getString(2));
				p.setQuantity(result.getInt(4));
				p.setPrice(result.getDouble(3));
				plist.add(p);
				
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		out.println("<table border=1>");
		out.println("<tr><th>Product name</th><th>Price</th><th>Quantity</th></tr>");
		for (Product product : plist) {
			
			out.println("<tr><td>" + product.getProductName()+ "</td><td>" + product.getPrice() + "</td><td>" + product.getQuantity()+ "</td></tr>");	
		}
		out.println("</table>");
    }
		
}



