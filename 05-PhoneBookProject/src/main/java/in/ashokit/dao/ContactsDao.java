package in.ashokit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ashokit.dto.ContactsDto;
import in.ashokit.dto.RegistrationDto;
import in.ashokit.util.ConnectionFactory;

public class ContactsDao {

	public boolean saveUserData(ContactsDto dto, int userId) throws SQLException {

		boolean saveUserData = false;

		String sql = "insert into user_contacts(uid, name, email, phno) values (?, ?, ?,?)";

		Connection conn = ConnectionFactory.getConn();
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, userId); // Set the user ID
		stmt.setString(2, dto.getName());
		stmt.setString(3, dto.getEmail());
		stmt.setInt(4, dto.getPhno());

		int count = stmt.executeUpdate();

		if (count > 0) {
			saveUserData = true;
		}

		return saveUserData;

	}

	/*
	 * id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255),
	 * phno int(12)
	 */
	public List<ContactsDto> getContacts(int userId) throws SQLException {
		List<ContactsDto> contactList = new ArrayList<>();

		String sql = "select * from user_contacts where uid = ?";

		Connection conn = ConnectionFactory.getConn();
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, userId);

		ResultSet rst = stmt.executeQuery();

		while (rst.next()) {
			int id = rst.getInt("id");
			String name = rst.getString("name");
			String email = rst.getString("email");
			int phno = rst.getInt("phno");

			ContactsDto dtos = new ContactsDto();
			dtos.setId(id);
			dtos.setName(name);
			dtos.setEmail(email);
			dtos.setPhno(phno);

			contactList.add(dtos);
		}

		return contactList;

	}

}
