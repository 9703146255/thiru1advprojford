package in.thiru.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.thiru.dto.ProductDTO;
import in.thiru.util.ConnectionFactory;

public class ProductDao {
	private List<ProductDTO> products = new ArrayList<>();

	public boolean saveData(ProductDTO product) throws SQLException {
		boolean isSaved = false;

		String sql = "INSERT INTO product_info (product_name, product_price, product_quantity) VALUES (?, ?, ?)";

		//step-1 : getting the connection
		Connection conn = ConnectionFactory.getConn().getConnection();
		
		//step-2 : creating statement obj 
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // Request generated keys

		//step-3 : get the data from dto and set to stmt obj
		stmt.setString(1, product.getpName());
		stmt.setInt(2, product.getPprice());
		stmt.setInt(3, product.getpQuantity());

		//step-4 : execute the query
		int count = stmt.executeUpdate();

		//step-4 : process the result
		if (count > 0) {
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				int generatedId = generatedKeys.getInt(1);
				product.setpId(generatedId); // Set the auto-generated ID in your ProductDTO object
				isSaved = true;
			}
		}

		// Close resources (stmt, conn) here

		return isSaved;
	}

	public List<ProductDTO> getAllProducts() {
		List<ProductDTO> products = new ArrayList<>();
		
		
		try {
			Connection conn = ConnectionFactory.getConn().getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM product_info");
			while (rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setpId(rs.getInt("product_id"));
				product.setpName(rs.getString("product_name"));
				product.setPprice(rs.getInt("product_price"));
				product.setpQuantity(rs.getInt("product_quantity"));
				products.add(product);
			}
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public ProductDTO getProductById(int id) {
		ProductDTO product = null;
		try {
			Connection conn = ConnectionFactory.getConn().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product_info WHERE product_id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				product = new ProductDTO();
				product.setpId(rs.getInt("product_id"));
				product.setpName(rs.getString("product_name"));
				product.setPprice(rs.getInt("product_price"));
				product.setpQuantity(rs.getInt("product_quantity"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
}
