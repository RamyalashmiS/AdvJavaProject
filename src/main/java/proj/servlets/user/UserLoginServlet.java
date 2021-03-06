package proj.servlets.user;

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

import proj.entity.users.User;
import proj.persist.user.UserDAOImplement;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	UserDAOImplement userdao = new UserDAOImplement();

	public UserLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		RequestDispatcher rd;

		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		System.out.println("in jpaservlet");
		
		User retUserDao = userdao.readUser(user.getEmail());
		
//		Cookie cookies[] = request.getCookies();
//
//		if (cookies.length == 0) {
//			Cookie cookieEmailObj = new Cookie("emartEmailCookie", user.getEmail());
//			Cookie cookiePassObj = new Cookie("emartPassCookie", user.getPassword());
//			cookieEmailObj.setMaxAge(60*60*24*30);
//			cookiePassObj.setMaxAge(60*60*24*30);
//			response.addCookie(cookiePassObj);
//			response.addCookie(cookieEmailObj);	
//		}

		if (retUserDao == null) {
			rd = request.getRequestDispatcher("/userRegister.jsp");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<p class='h3 text-primary text-center'>Seems like you're not a registered user.... </p>");
			out.println("<p class='h3 text-primary text-center'>Please register and login!!! </p>");
			rd.include(request, response);
		} else if (!retUserDao.getPassword().matches(password)) {
			rd = request.getRequestDispatcher("/login.jsp");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<p class='h3 text-danger text-center'>Please check the password!!! </p>");
			
			rd.include(request, response);
		} else {
			rd = request.getRequestDispatcher("showProducts");
			HttpSession session=request.getSession();
			session.setAttribute("user", true);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.println("<p class='h3 text-warning'>Hi " + retUserDao.getUserName()
					+ "!!! Welcome !!! </p>");
			rd.include(request, response);
		}
	}

}

