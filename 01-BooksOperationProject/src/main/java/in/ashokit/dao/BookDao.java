	package in.ashokit.dao;
	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	
	import javax.sql.DataSource;
	
	import in.ashokit.model.Book;
	
	public class BookDao {
	
		public boolean saveBooks(Book book) throws SQLException {
		    boolean isSave = false;
		    String sql = "INSERT INTO books (bookName, BookPrice, AuthorName) VALUES (?, ?, ?)";
		    
		    DataSource ds = ConnectionFactory.getConn();
		    try (Connection conn = ds.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		        stmt.setString(1, book.getBookName());
		        stmt.setDouble(2, book.getBookPrice());
		        stmt.setString(3, book.getAuthorName());

		        int count = stmt.executeUpdate();
		        if (count > 0) {
		            ResultSet generatedKeys = stmt.getGeneratedKeys();
		            if (generatedKeys.next()) {
		                int generatedId = generatedKeys.getInt(1);
		                book.setBookId(generatedId); // Set the auto-generated ID in your Book object
		                isSave = true;
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return isSave;
		}

		
		public List<Book> getBooksData() throws Exception
		{
			
			//bookId  bookName   BookPrice AuthorName
			
			 List<Book> books = new ArrayList<>();
		        String sql = "SELECT bookId, bookName, BookPrice, AuthorName FROM books";
		        		
		        DataSource ds = ConnectionFactory.getConn();
		        Connection conn = ds.getConnection();
		        Statement stmt = conn.createStatement();
		        ResultSet resultSet = stmt.executeQuery(sql);
	
		            while (resultSet.next()) 
		        {
		                Book book = new Book();
		                book.setBookId(resultSet.getInt("bookId"));
		                book.setBookName(resultSet.getString("bookName"));
		                book.setBookPrice(resultSet.getDouble("BookPrice"));
		                book.setAuthorName(resultSet.getString("AuthorName"));
		                
		                books.add(book);
		            
		        }
	
		        return books;
			
			
			
		  
		}
	
	}
