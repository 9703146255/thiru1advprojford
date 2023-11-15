package in.ashokit.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ashokit.dao.RegistrationDao;
import in.ashokit.dto.RegistrationDto;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// step-1: get the form data
		// rname remail rpassword rphno
		String rname = req.getParameter("rname");
		String remail = req.getParameter("remail");
		String rpassword = req.getParameter("rpassword");
		String phno = req.getParameter("rphno");
		int rphno = Integer.parseInt(phno);

		// step-2:set the data to the dto obect

		RegistrationDto dto = new RegistrationDto();
		dto.setName(rname);
		dto.setEmail(remail);
		dto.setPassword(rpassword);
		dto.setPhno(rphno);

		// step-3 :calling the DAO class and sending the data to the DAO class

		RegistrationDao dao = new RegistrationDao();

		try {
			boolean saveUser = dao.saveUser(dto);
			if (saveUser) {
				req.setAttribute("successMessage", "Registration Successfull");
			} else {
				req.setAttribute("errorMessage", "Registration failed");
			}

			req.getRequestDispatcher("register.jsp").include(req, resp);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
