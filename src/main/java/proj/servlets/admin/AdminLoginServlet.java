package proj.servlets.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proj.entity.admin.*;
import proj.persist.admin.AdminDAOImplement;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	AdminDAOImplement admindao = new AdminDAOImplement();

	public AdminLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		RequestDispatcher rd;

		Admin admin = new Admin();
		admin.setEmail(email);
		admin.setPassword(password);
		
		System.out.println("in jpaservlet");
		
		
		Admin retAdminDao = admindao.readAdmin(admin.getEmail());


		if (retAdminDao == null) {
			rd = request.getRequestDispatcher("/adminLogin.jsp");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<p class='h3 text-primary text-center'>Seems like you're not a registered admin.... </p>");
			out.println("<p class='h3 text-primary text-center'>Please check your emailId !!! </p>");
			rd.include(request, response);
		} else if (!retAdminDao.getPassword().matches(password)) {
			rd = request.getRequestDispatcher("/adminLogin.jsp");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<p class='h3 text-danger text-center'>Please check the password!!! </p>");
			
			rd.include(request, response);
		} else {
			rd = request.getRequestDispatcher("addProducts.jsp");
			HttpSession session=request.getSession();
			session.setAttribute("admin", true);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.println("<p class='h3 text-warning'>Hi Admin !!! Welcome !!! </p>");
			rd.include(request, response);
		}
	}

}

