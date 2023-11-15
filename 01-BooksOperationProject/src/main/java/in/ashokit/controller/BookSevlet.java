package in.ashokit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ashokit.dao.BookDao;
import in.ashokit.model.Book;

@WebServlet("/BookSevlet")
public class BookSevlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		resp.setContentType("text/html");
		
		String name = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		String author = req.getParameter("author");
		
		Book b=new Book();
		
		
		b.setBookName(name);
		b.setBookPrice(price);
		b.setAuthorName(author);
		
		try {  
		    BookDao dao = new BookDao();
		    boolean saveBooks = dao.saveBooks(b);

		    if (saveBooks) {
		        req.setAttribute("successMessage", "Book successfully inserted!");
		    } else {
		        req.setAttribute("errorMessage", "Failed to insert the book.");
		    }
		    req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (Exception e) {
		    e.printStackTrace();
		    resp.sendRedirect("error.jsp");
		}


	        
		
		
		
	}
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		 try {
	            BookDao dao = new BookDao();
	            List<Book> books = dao.getBooksData();
	            
	            
	            request.setAttribute("books", books);
	            
	            request.getRequestDispatcher("data.jsp").forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Handle database errors
	            response.sendRedirect("error.jsp"); // Redirect to an error page
	        }
		
	}

	

}
