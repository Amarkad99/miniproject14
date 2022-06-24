package miniproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class Sign_up extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		
		String contact = request.getParameter("contact");
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		String gender = request.getParameter("gender");
		
		DAO dao = new DAO();
		
		dao.adduser(name, gender, contact, username, password);
		out.println("<h1>User Added Sussefully...</h1> <br/>");
		out.println("<html><body><a href='SignIn.html'>Go back</a>");
		out.println("</body></html>");
	}


}
