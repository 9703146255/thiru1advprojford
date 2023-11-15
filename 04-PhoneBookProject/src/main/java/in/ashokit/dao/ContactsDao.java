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
	
	
	public boolean saveUserData(ContactsDto dto) throws SQLException
	{
		
		boolean saveUserData =false;
		
		String sql="insert into user_contacts(name, email, phno) values (?,?,?)";
		
		Connection conn = ConnectionFactory.getConn();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, dto.getName());
		stmt.setString(2, dto.getEmail());
		stmt.setInt(3, dto.getPhno());
		
		int count = stmt.executeUpdate();
		
		
		if(count>0)
		{
			saveUserData =true;
		}
		
		return saveUserData;
		
	}
	/*
	 id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
	email VARCHAR(255),   
    phno int(12)
	 */
	public List<RegistrationDto> getContacts() throws SQLException
	{
	    List<RegistrationDto> contactList=new ArrayList<>();
		
	    String sql="select * from user_contacts";
	    
	    Connection conn = ConnectionFactory.getConn();
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    ResultSet rst = stmt.executeQuery();
	    
	    while(rst.next())
	    {
	    	int id = rst.getInt("id");
	    	String name = rst.getString("name");
	    	String email = rst.getString("email");
	    	 int phno = rst.getInt("phno");
	    	
	    	RegistrationDto dtos = new RegistrationDto();
	    	dtos.setId(id);
	    	dtos.setName(name);
	    	dtos.setEmail(email);
	    	dtos.setPhno(phno);
	    	
	    	contactList.add(dtos);
	    }
	    
	    
	    
	    
	    
		
		return contactList;
		
	}
	
	
	
	

}
