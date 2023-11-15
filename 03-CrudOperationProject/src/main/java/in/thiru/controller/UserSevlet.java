package in.thiru.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.thiru.dao.UserDao;
import in.thiru.dto.UserDto;


@WebServlet("/UserSevlet")
public class UserSevlet extends HttpServlet {

       
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserDao dao=new UserDao();
		try {
			List<UserDto> allUsers = dao.getAllUsers();
			
			
			 req.setAttribute("allUsers", allUsers);
			 req.getRequestDispatcher("view.jsp").forward(req, resp);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	}

	//<!-- name   email phone -->
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//collecting the form data
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phnone = req.getParameter("phone");
		
		
		UserDto dto = new  UserDto();
		dto.setName(name);
		dto.setEmail(email);
		dto.setPhno(Integer.parseInt(phnone));
		
		
		UserDao dao=new UserDao();
		try {
			boolean saveUser = dao.saveUser(dto);
			if(saveUser)
			{
				req.setAttribute("successMessage", "user added..");
				req.getRequestDispatcher("user.jsp").include(req, resp);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
	
	}

}
