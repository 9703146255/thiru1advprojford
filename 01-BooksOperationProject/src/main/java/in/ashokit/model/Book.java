package in.ashokit.model;

public class Book 
{
 
	//bookId  bookName   BookPrice AuthorName
	private int bookId;
	private String bookName;
	private Double BookPrice;
	private String AuthorName;
	
	
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getBookPrice() {
		return BookPrice;
	}
	public void setBookPrice(Double bookPrice) {
		BookPrice = bookPrice;
	}
	public String getAuthorName() {
		return AuthorName;
	}
	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", BookPrice=" + BookPrice + ", AuthorName="
				+ AuthorName + "]";
	}
	public Book(int bookId, String bookName, Double bookPrice, String authorName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		BookPrice = bookPrice;
		AuthorName = authorName;
	}
	public Book() {}
	
	
	
	
	
	
	
	
	
}
