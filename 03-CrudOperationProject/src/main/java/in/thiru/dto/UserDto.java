package in.thiru.dto;
/*
 id	int	NO	PRI		auto_increment
name	varchar(30)	YES			
email	varchar(30)	YES			
phno	int	YES			
 */
public class UserDto 
{

	private int id;
	private String name;
	private String email;
	private int phno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	
	
	
	
}
