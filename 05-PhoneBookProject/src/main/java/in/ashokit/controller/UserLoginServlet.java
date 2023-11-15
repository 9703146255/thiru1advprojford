package in.ashokit.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ashokit.dao.RegistrationDao;
import in.ashokit.dto.RegistrationDto;

@WebServlet("/UserLogin")
public class UserLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	// <!-- lemail lpassword -->

	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// Getting the form data
		String lemail = req.getParameter("lemail");
		String lpassword = req.getParameter("lpassword");

		// Create RegistrationDto
		RegistrationDto dto = new RegistrationDto();
		dto.setEmail(lemail);
		dto.setPassword(lpassword);

		// Create RegistrationDao
		RegistrationDao dao = new RegistrationDao();
		try {
			String userName = dao.authUser(lemail, lpassword);
			if (userName != null) {

				int userId = dao.getUserId(lemail);

				if (userId != -1) { // Check if the user ID is valid
					HttpSession session = req.getSession(); // Get the session
					session.setAttribute("userId", userId);
					req.setAttribute("userName", userName);
					req.getRequestDispatcher("dashboard.jsp").forward(req, response);
				}
			} else {
				req.setAttribute("errorMessage", "Invalid credentials");
				req.getRequestDispatcher("login.jsp").forward(req, response); // Forward back to the login page
			}
		} catch (SQLException e) {
			// Handle SQLException
			e.printStackTrace();
			req.setAttribute("errorMessage", "An error occurred during authentication");
			req.getRequestDispatcher("login.jsp").forward(req, response); // Forward back to the login page
		}
	}

}
