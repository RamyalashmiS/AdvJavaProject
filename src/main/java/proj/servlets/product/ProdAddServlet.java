package proj.servlets.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proj.entity.products.Product;

import proj.persist.product.ProductDAOImplement;
/**
 * Servlet implementation class ProdAddServlet
 */
@WebServlet("/addProducts")
public class ProdAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ProductDAOImplement ProductDAOImpl=new ProductDAOImplement();
    public ProdAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prodname=request.getParameter("prodname");
		String desc=request.getParameter("desc");
		Integer cost=Integer.parseInt(request.getParameter("cost"));
			
		Product prod=new Product();
		prod.setCost(cost);
		prod.setDescription(desc);
		prod.setProdName(prodname);
		System.out.println("in jpaservlet");
		ProductDAOImpl.insertProduct(prod);
		
		RequestDispatcher rd = request.getRequestDispatcher("showProducts");
		response.setContentType("text/html");		
		PrintWriter out=response.getWriter();
        out.println("<h4 class='text-success'>Product is added successfully !!!</h4>");
        
        
		rd.include(request, response);
	}

}
