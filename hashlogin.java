package miniproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class hashlogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		DAO dao=new DAO();
		
PrintWriter pw=response.getWriter();
		
		ResultSet rs = null;
		
		rs=dao.getRows("select * from userinfo");
		
		
		String uname1=request.getParameter("username");
		
		String password1=request.getParameter("password");
		
		HashMap<String,String> h=new HashMap<String,String>();
		
		try {
			while(rs.next())
			{
				try {
					h.put(rs.getString(4),rs.getString(5));
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	
		pw.println("<html><body style='color:blue'>");

	if(h.containsKey(uname1)&& h.containsValue(password1))
	{
		
	
		pw.println("<h1>login Succesfull</h1>");
		pw.println("<a href= GoodBye.html>Close</a>");
	}	
	else
	{
		
		pw.println("<h1>login UnSuccesfull<h1><br/>");
		pw.println("<a href= SignIn.html>Sign in for another user</a>");
		
	}
	pw.println("</body></html>");
	
		pw.close();
	}
		
		
		
	}


