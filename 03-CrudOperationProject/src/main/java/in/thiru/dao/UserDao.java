package in.thiru.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.thiru.dto.UserDto;
import in.thiru.util.ConnectionFactory;

/*
id	int	NO	PRI		auto_increment
name	varchar(30)	YES			
email	varchar(30)	YES			
phno	int	YES			
 */

public class UserDao {
	
	
	
	public boolean saveUser(UserDto user) throws SQLException
	{
		boolean isSaved=false;
		
		String sql="insert into user_crud(name,email,phno) values(?,?,?)";
		
		Connection conn = ConnectionFactory.getConn();
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.setInt(3, user.getPhno());
		
		int count = stmt.executeUpdate();
		if(count>0)
		{
			isSaved=true;
		}
		
		
		return isSaved;
	}
	/*
	 id	int	NO	PRI		auto_increment
name	varchar(30)	YES			
email	varchar(30)	YES			
phno	int	YES			
	 */
	

	public List<UserDto> getAllUsers() throws SQLException {
	    List<UserDto> userList = new ArrayList<>();
	    String sql = "SELECT * FROM user_crud";

	    try (Connection conn = ConnectionFactory.getConn();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rst = stmt.executeQuery()) {

	        while (rst.next()) {
	            UserDto dto = new UserDto();
	            dto.setName(rst.getString("name"));
	            dto.setEmail(rst.getString("email"));
	            dto.setPhno(rst.getInt("phno"));
	            userList.add(dto);
	        }
	    } catch (SQLException e) {
	        // Handle the exception (e.g., log it) or throw it if needed.
	        e.printStackTrace();
	    }
	    
	    return userList;
	}

	}
	
	
	


