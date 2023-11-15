package in.thiru.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.thiru.dao.ProductDao;
import in.thiru.dto.ProductDTO;


@WebServlet("/ProductServlet")
public class ProductSevlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		//step-1 : collecting the form data
		String name = req.getParameter("pname");
		int price = Integer.parseInt(req.getParameter("pprice"));
		int quantity = Integer.parseInt(req.getParameter("pquantity"));
		
		//step-2 :creating dto class object to give input to DAO class method
		ProductDTO dto=new ProductDTO();
		dto.setpName(name);
		dto.setPprice(price);
		dto.setpQuantity(quantity);
		
		try {  
		    ProductDao dao = new ProductDao();
		   boolean isSavedData = dao.saveData(dto);

		   
		   
		   
		 //step-3 :   GETTIN SUCCESS OR FAILURE BASED ON RETURN OF DAO CLASS METHOD
		   
		    if (isSavedData) {
		        req.setAttribute("successMessage", "product successfully inserted!");
		    } else {
		        req.setAttribute("errorMessage", "Failed to insert the product.");
		    }
		    req.getRequestDispatcher("product.jsp").forward(req, resp);
		} catch (Exception e) {
		    e.printStackTrace();
		    resp.sendRedirect("error.jsp");
		}
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		        String action = request.getParameter("action");

		        
		        //comparing form data and 
		        if ("search".equals(action)) {
		        	
		            String productId = request.getParameter("productId");
		            if (productId != null && !productId.isEmpty()) {
		                int id = Integer.parseInt(productId);
		                ProductDao productDAO = new ProductDao();
		                List<ProductDTO> product;
						try {
							product = productDAO.getProductData(id);
							 request.setAttribute("product", product);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}    
		                
		            } 

		            request.getRequestDispatcher("/search.jsp").forward(request, response);

		        }
		    }
	

}
