
package in.ashokit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ashokit.dto.RegistrationDto;
import in.ashokit.util.ConnectionFactory;

public class RegistrationDao {

	public boolean saveUser(RegistrationDto rdto) throws SQLException {

		String sql = "insert into user_registration(name, email, password, phno) values (?,?,?,?)";

		boolean saveUser = false;

		// step-1 : get the connection
		Connection conn = ConnectionFactory.getConn();

		// step-2 : create a prepare statement
		PreparedStatement pstmt = conn.prepareStatement(sql);

		//// step-3 : set the values to the positionsal parametneres

		pstmt.setString(1, rdto.getName());
		pstmt.setString(2, rdto.getEmail());
		pstmt.setString(3, rdto.getPassword());
		pstmt.setInt(4, rdto.getPhno());

		// step-4 : execute the query
		int count = pstmt.executeUpdate();

		// step-5 : process the result
		if (count > 0) {
			saveUser = true;
		}

		// step-6 :close the connections
		conn.close();

		return saveUser;

	}

	public String authUser(String eMail, String pwd) throws SQLException {
		String UserName = null;

		String sql = "select * from user_registration where email = ? and password = ?";
		Connection conn = ConnectionFactory.getConn();
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, eMail);
		stmt.setString(2, pwd);

		ResultSet rst = stmt.executeQuery();

		while (rst.next()) {
			UserName = rst.getString("name");
		}

		return UserName;
	}
	
	public int getUserId(String email) throws SQLException {
	    int userId = -1; // Default value to indicate no user found

	    String sql = "SELECT id FROM user_registration WHERE email = ?";
	    Connection conn = ConnectionFactory.getConn();
	    PreparedStatement stmt = conn.prepareStatement(sql);

	    stmt.setString(1, email);

	    ResultSet rs = stmt.executeQuery();

	    if (rs.next()) {
	        userId = rs.getInt("id");
	    }

	    conn.close();
	    return userId;
	}


}
