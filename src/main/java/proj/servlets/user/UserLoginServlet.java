package proj.servlets.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	UserDAOImplement userdao=new UserDAOImplement();
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
			
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setUserName(username);
		System.out.println("in jpaservlet");
		userdao.readUser(user);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/showProducts.jsp");
		rd.forward(request, response);
	}

}
